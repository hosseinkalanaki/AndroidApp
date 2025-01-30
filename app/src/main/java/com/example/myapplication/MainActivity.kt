package com.example.myapplication

import Center
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Generate 10 sample centers with random temperature & humidity
        val centers = List(10) { index ->
            Center(
                centerNumber = index + 1,
                temperature1 = String.format("%.1f", Random.nextDouble(20.0, 30.0)).toDouble(),
                temperature2 = String.format("%.1f", Random.nextDouble(20.0, 30.0)).toDouble(),
                humidity = Random.nextInt(40, 70)
            )
        }

        // Setup RecyclerView with Grid Layout (2 columns)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = CenterAdapter(centers)
    }



}
