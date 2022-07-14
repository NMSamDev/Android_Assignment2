package com.example.carlosmendez_assignment_2.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.carlosmendez_assignment_2.databinding.FragmentClassicBinding
import com.example.carlosmendez_assignment_2.network.ApiService
import com.example.data.carlosmendez_assignment_2.SongResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClassicFragment: Fragment() {
    lateinit var binding: FragmentClassicBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClassicBinding.inflate(layoutInflater)
        val view = binding.root
        fetchRandomUsers()
        return view
    }

    private fun fetchRandomUsers() {
        ApiService.getRetrofitInstance()?.create(ApiService::class.java)
            ?.getSongResponse("classicK")?.enqueue(object: Callback<SongResponse> {
                override fun onFailure(call: Call<SongResponse>, t: Throwable) {
                    Toast.makeText(context, "Failed to fetch users", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<SongResponse>,
                    response: Response<SongResponse>
                ) {
                    if(response.isSuccessful){
                        val userAdapter = SongAdapter(response.body()!!.results)
                        binding.rvUserList.adapter = userAdapter
                    }
                }
            })
    }
}