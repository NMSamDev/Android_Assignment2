package com.example.carlosmendez_assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carlosmendez_assignment_2.R
import com.example.carlosmendez_assignment_2.databinding.ActivityMainBinding
import com.example.carlosmendez_assignment_2.views.ViewPagerAdapter

import com.google.android.material.tabs.TabLayoutMediator

val musicArray = arrayOf("Rock", "Classic", "Pop")
val iconsArray = arrayOf(R.drawable.ic_rock, R.drawable.ic_classic, R.drawable.ic_pop)

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabsLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = musicArray[position]
            tab.icon = getDrawable(iconsArray[position])
        }.attach()
    }
}