package com.example.drawerlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drawerlayoutdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //设置阴影颜色为白色
        binding.drawerLayout.setScrimColor(ContextCompat.getColor(this, R.color.white))

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val mainAdapter = MainAdapter(resources.getStringArray(R.array.item_array_name))
        binding.recyclerView.adapter = mainAdapter
        mainAdapter.notifyDataSetChanged()
        mainAdapter.setOnItemClickListener {
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        }


    }
}