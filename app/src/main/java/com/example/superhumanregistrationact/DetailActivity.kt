package com.example.superhumanregistrationact

import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
        val bitmapPath = bundle.getString(MainActivity.BITMAP_KEY)!!
        val bitmap = BitmapFactory.decodeFile(bitmapPath)

        binding.superhumanPicture.setImageBitmap(bitmap)
        binding.superhuman = superHuman
    }
}