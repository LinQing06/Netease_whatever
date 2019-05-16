package com.example.linqing.netease_whatever.PlayList

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.linqing.netease_whatever.R
import com.example.linqing.netease_whatever.Sevice.FuncService
import com.example.linqing.netease_whatever.Sevice.Status

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemdata: Playlist
    internal var userid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        //这里好像有、问题
        lateinit var intent: Intent
        userid = intent.getIntExtra("id", 0)


        init()
        initview()

    }

    private fun init() {
        val linearLayout = LinearLayoutManager(this)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        adapter = ListAdapter(this)
        recyclerView.layoutManager = linearLayout
        recyclerView.adapter = adapter

    }

    private fun initview() {

        FuncService.getListData(userid) { status, data ->
            runOnUiThread {
                when (status) {
                    Status.SUCCESSFUL -> {
                        updateList()

                    }
                    Status.WRONG -> Toast.makeText(
                            this,
                            "获取不到歌单列表",
                            Toast.LENGTH_SHORT
                    ).show()


                    Status.OTHER -> Toast.makeText(
                            this,
                            "似乎出了点问题，一定不是开发者的错（误）",
                            Toast.LENGTH_SHORT
                    ).show()


                }
            }

        }

    }

    private fun updateList() {
        adapter.update(itemdata)


    }
}
