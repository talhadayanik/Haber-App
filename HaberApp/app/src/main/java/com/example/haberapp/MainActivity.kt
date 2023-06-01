package com.example.haberapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView
    val service = NewsService()
    lateinit var newsList : List<News>

    var policy : StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StrictMode.setThreadPolicy(policy)

        listView = findViewById(R.id.listNews)
        newsList = service.getNews()

        val customAdapter = NewsCustomAdapter(this, newsList)
        listView.adapter = customAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            startActivity(activity_web.newWebActivity(this, newsList[position].href))
        }

    }
}