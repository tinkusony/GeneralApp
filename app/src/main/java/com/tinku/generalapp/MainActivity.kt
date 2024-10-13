package com.tinku.generalapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tinku.generalapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btElevated.setOnClickListener {
            showToast(this, "Button Elevated clicked")
        }
        binding.btFilled.setOnClickListener {
            showToast(this, "Button Filled clicked")
            startActivity(Intent(this,ActivityFab::class.java))
        }
        binding.btTonal.setOnClickListener {
            showToast(this, "Button Tonal clicked")
        }
        binding.apply {
            btOutlined.setOnClickListener {
                showToast(this@MainActivity, "Button Outlined clicked")
                if (normalFab.isShown) {
                    normalFab.hide()
                } else {
                    normalFab.show()
                }
            }

            btText.setOnClickListener {
                showToast(this@MainActivity, "Button Text clicked")
                if (extendedFab.isExtended){
                    extendedFab.shrink()
                }else{
                    extendedFab.extend()
                }
            }
        }
    }
    private fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}