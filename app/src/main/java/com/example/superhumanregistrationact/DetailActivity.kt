package com.example.superhumanregistrationact

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superhumanregistrationact.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val superHuman = bundle.getParcelable<SuperHuman>(MainActivity.SUPERHUMAN_KEY)!!
        val bitmap = bundle.getParcelable<Bitmap>(MainActivity.BITMAP_KEY)!!

        binding.superhumanPicture.setImageBitmap(bitmap)
        binding.superhuman = superHuman
    }
}