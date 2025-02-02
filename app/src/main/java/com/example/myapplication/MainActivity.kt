package com.example.myapplication

import Center
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import kotlin.random.Random
import java.math.BigDecimal
import java.math.RoundingMode
import okhttp3.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class MainActivity : AppCompatActivity() {

    private lateinit var webSocket: WebSocket
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        this.connect()
        // Generate 10 sample centers with random temperature & humidity
//        val centers = List(10) { index ->
//            Center(
//                centerNumber = index + 1,
//                temperature1 = String.format("%.1f", Random.nextDouble(20.0, 30.0)).toDouble(),
//                temperature2 = String.format("%.1f", Random.nextDouble(20.0, 30.0)).toDouble(),
//                temperature3 = String.format("%.1f", Random.nextDouble(20.0, 30.0)).toDouble(),
//                humidity = Random.nextInt(40, 70)
//            )
//        }

        // Setup RecyclerView with Grid Layout (2 columns)

//        recyclerView.adapter = CenterAdapter(centers)
    }

    fun connect() {
        var url="ws://87.107.54.138:8090/WebSocket"
        val request = Request.Builder().url(url).build()
        val listType = object : TypeToken<List<Center>>() {}.type


        webSocket = client.newWebSocket(request, object : WebSocketListener() {

            override fun onOpen(webSocket: WebSocket, response: Response) {
                Log.d("WebSocket", "Connected to server")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.d("WebSocket", "Received: $text")
                val centers: List<Center> = Gson().fromJson(text, listType)
                runOnUiThread {
                    updateData(centers)
                }
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                Log.d("Websocket","Connection Error")
            }
        })
    }

    fun updateData(centers: List<Center>){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = CenterAdapter(centers)
    }

}
