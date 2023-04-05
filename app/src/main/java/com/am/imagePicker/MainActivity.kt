package com.am.imagePicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.am.imagePicker.databinding.ActivityMainBinding
import com.am.imagePicker.picker.ImagePicker

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val imagePicker = ImagePicker.with(this){ uri ->
        if (uri != null) {
            binding.selectedImage.setImageURI(uri)
        } else {
            Toast.makeText(
                this,
                "Something went wrong!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(binding.root)
        }
        binding.btnPickPhoto.setOnClickListener {
            imagePicker.getImageFromCamera(this)
        }
    }
}