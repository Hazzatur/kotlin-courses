package com.example.superhumanregistrationact

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import com.example.superhumanregistrationact.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    companion object {
        const val SUPERHUMAN_KEY = "superHuman"
        const val BITMAP_KEY = "superHumanPicture"
    }

    private lateinit var picture: ImageView
    private var superHumanPicture: Bitmap? = null
    private var picturePath = ""

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()) {
            success ->
        if (success && picturePath.isNotEmpty()) {
            superHumanPicture = BitmapFactory.decodeFile(picturePath)
            picture.setImageBitmap(superHumanPicture)
        }
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
        intent.putExtra(BITMAP_KEY, picturePath)
        startActivity(intent)
    }

    private fun openCamera() {
        val file = createImageFile()
        val uri = FileProvider.getUriForFile(this, "$packageName.provider", file)
        // Uri.fromFile(file) // for older version Build.VERSION.SDK_INT < Build.VERSION_CODES.N
        getContent.launch(uri)
    }

    private fun createImageFile(): File {
        val fileName = "superhuman_profile_picture"
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File.createTempFile(fileName, ".jpg", fileDirectory)
        picturePath = file.absolutePath
        return file
    }
}
