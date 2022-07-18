package com.example.superhumanregistrationact

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import com.example.superhumanregistrationact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val SUPERHUMAN_KEY = "superHuman"
        const val BITMAP_KEY = "superHumanPicture"
    }

    private lateinit var picture: ImageView
    private var superHumanPicture: Bitmap? = null

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        bitmap ->
        superHumanPicture = bitmap
        picture.setImageBitmap(superHumanPicture)
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

        picture = binding.superhumanPicture
        binding.superhumanPicture.setOnClickListener {
            openCamera()
        }
    }

    private fun openDetailActivity(superHuman: SuperHuman) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(SUPERHUMAN_KEY, superHuman)
        intent.putExtra(BITMAP_KEY, picture.drawable.toBitmap())
        startActivity(intent)
    }

    private fun openCamera() {
        getContent.launch(null)
    }
}
