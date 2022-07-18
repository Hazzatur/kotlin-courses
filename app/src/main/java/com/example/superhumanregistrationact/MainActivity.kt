package com.example.superhumanregistrationact

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.example.superhumanregistrationact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val SUPERHUMAN_KEY = "superHuman"
        const val BITMAP_KEY = "superHumanPicture"
    }

    private lateinit var picture: ImageView

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

    //TODO this methods are deprecated, search alternative
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 1000){
            val extras = data?.extras
            val pictureBitmap = extras?.getParcelable<Bitmap>("data")
            picture.setImageBitmap(pictureBitmap)
        }
    }
}
