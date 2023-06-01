package com.example.haberapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class NewsCustomAdapter(private val context: Activity, private val list: List<News>) : ArrayAdapter<News>(context, R.layout.news_list_item, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(R.layout.news_list_item, null, true)

        val title = view.findViewById<TextView>(R.id.txtTitle)
        val image = view.findViewById<ImageView>(R.id.imgNews)

        val news = list.get(position)

        title.text = "${news.title}"

        Glide.with(view).load(news.image).into(image)

        return view
    }
}