package com.example.haberapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class activity_web : AppCompatActivity() {

    lateinit var webView : WebView

    companion object{
        fun newWebActivity(context: Context, url : String) = Intent(context, activity_web::class.java).apply {
            putExtra("url", url)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.webView)
        val url = intent.extras!!.getString("url").toString()

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }
}