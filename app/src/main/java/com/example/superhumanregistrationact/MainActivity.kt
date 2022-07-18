package com.example.superhumanregistrationact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superhumanregistrationact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val SUPERHUMAN_NAME_KEY = "name"
        const val SUPERHUMAN_ALTER_EGO_KEY = "alter_ego"
        const val SUPERHUMAN_BIO_KEY = "biography"
        const val SUPERHUMAN_POWER_KEY = "power_level"
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
            openDetailActivity(
                name,
                alterEgo,
                biography,
                powerLevel
            )
        }
    }

    private fun openDetailActivity(
        name: String,
        alterEgo: String,
        biography: String,
        powerLevel: Float
    ) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(SUPERHUMAN_NAME_KEY, name)
        intent.putExtra(SUPERHUMAN_ALTER_EGO_KEY, alterEgo)
        intent.putExtra(SUPERHUMAN_BIO_KEY, biography)
        intent.putExtra(SUPERHUMAN_POWER_KEY, powerLevel)
        startActivity(intent)
    }
}