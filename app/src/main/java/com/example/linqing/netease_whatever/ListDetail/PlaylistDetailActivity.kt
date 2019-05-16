package com.example.linqing.netease_whatever.ListDetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.linqing.netease_whatever.R

class PlaylistDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_detail)
        val listview = findViewById(R.id.list_item)as RecyclerView
        listview.layoutManager = LinearLayoutManager(this)

    }
}