package com.example.superhumanregistrationact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superhumanregistrationact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val SUPERHUMAN_KEY = "superHuman"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.superhumanName.text.toString()
            val alterEgo = binding.superhumanAlterEgo.text.toString()
            val biography = binding.superhumanBio.text.toString()
            val powerLevel = binding.powerLevel.rating

            val superHuman = SuperHuman(
                name,
                alterEgo,
                biography,
                powerLevel
            )

            openDetailActivity(superHuman)
        }
    }

    private fun openDetailActivity(superHuman: SuperHuman) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(SUPERHUMAN_KEY, superHuman)
        startActivity(intent)
    }
}