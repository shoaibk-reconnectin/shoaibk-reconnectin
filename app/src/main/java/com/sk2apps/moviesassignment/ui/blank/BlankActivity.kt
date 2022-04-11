package com.sk2apps.moviesassignment.ui.blank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sk2apps.moviesassignment.R
import com.sk2apps.moviesassignment.databinding.ActivityBlankBinding
import com.sk2apps.moviesassignment.databinding.ActivityImageSpotBinding

class BlankActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlankBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank)
        binding = ActivityBlankBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.textViewBodyPartName.text = intent.getStringExtra("body_part").toString()
    }
}