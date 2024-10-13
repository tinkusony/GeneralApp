package com.tinku.generalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tinku.generalapp.databinding.ActivityFabBinding

class ActivityFab : AppCompatActivity() {
    private val activity = this
    private val binding by lazy {
        ActivityFabBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            //is se fab button hide and scroll hota h
            recyclerview.shrinkFabOnScroll(extendedFab)
//            recyclerview.hideFabOnScroll(hideFab)


            // recycler view
            val layoutManager = LinearLayoutManager(activity)
            recyclerview.layoutManager = layoutManager
            val data = mutableListOf<String>()
            repeat(100) {
                data.add("Item $it")
            }
            val adapter = MyAdapter(data)
            recyclerview.adapter = adapter

        }

    }
}