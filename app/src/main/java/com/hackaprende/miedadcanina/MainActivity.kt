package com.hackaprende.miedadcanina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hackaprende.miedadcanina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        Log.v("MainActivity", "ActivityCreated verbose")
//        Log.d("MainActivity", "ActivityCreated debug")
//        Log.i("MainActivity", "ActivityCreated info")
//        Log.w("MainActivity", "ActivityCreated warning")
//        Log.e("MainActivity", "ActivityCreated error")

        binding.calcButton.setOnClickListener {
            val ageString: String = binding.ageEditText.text.toString()
            if (ageString.isNotEmpty()) {
                val dogYears: Int = ageString.toInt() * 7
                binding.resultTextView.text  =  getString(R.string.result_age, dogYears)
            } else {
                Log.d("MainActivity", "ageString is empty")
                Toast.makeText(this, R.string.toast_enter_age, Toast.LENGTH_SHORT).show()
            }
        }
    }
}