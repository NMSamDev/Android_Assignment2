package com.example.carlosmendez_assignment_2.network

import com.example.data.carlosmendez_assignment_2.SongResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getSongResponse(
        @Query("term") term: String,
        @Query("amp;media") media: String,
        @Query("amp;entity") entity: String,
        @Query("amp;limit") limit: String
        ): retrofit2.Call<SongResponse>

    companion object {
        private var retrofit: Retrofit? = null
        val BASE_URL = "https://itunes.apple.com/"

        fun getRetrofitInstance(): Retrofit? {
            if(retrofit == null) {
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            }
            return retrofit
        }
    }

}