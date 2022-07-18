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
        val name = bundle.getString(MainActivity.SUPERHUMAN_NAME_KEY) ?: ""
        val alterEgo = bundle.getString(MainActivity.SUPERHUMAN_ALTER_EGO_KEY) ?: ""
        val biography = bundle.getString(MainActivity.SUPERHUMAN_BIO_KEY) ?: ""
        val powerLevel = bundle.getFloat(MainActivity.SUPERHUMAN_POWER_KEY)

        binding.superhumanName.text = name
        binding.superhumanAlterEgo.text = alterEgo
        binding.superhumanBio.text = biography
        binding.powerLevel.rating = powerLevel
    }
}