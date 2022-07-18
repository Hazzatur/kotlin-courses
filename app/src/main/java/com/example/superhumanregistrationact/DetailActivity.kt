package com.example.superhumanregistrationact

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

        binding.superhumanName.text = superHuman.name
        binding.superhumanAlterEgo.text = superHuman.alterEgo
        binding.superhumanBio.text = superHuman.biography
        binding.powerLevel.rating = superHuman.powerLevel
    }
}