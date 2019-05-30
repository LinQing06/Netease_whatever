package com.example.linqing.netease_whatever.ListDetail

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.linqing.netease_whatever.ListDetail.DetailService.getListDetailData

import com.example.linqing.netease_whatever.R
import com.example.linqing.netease_whatever.Sevice.Status

class PlaylistDetailActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListDetailAdapter
    private lateinit var list:ArrayList<Track?>
    internal var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_main)

        var intent = intent
        id = intent.getStringExtra("id")
        getInfo()


    }

    private fun init() {
        val linearLayout = LinearLayoutManager(this)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        adapter = ListDetailAdapter(this)
        recyclerView = findViewById(R.id.info_recy)
        recyclerView.layoutManager = linearLayout
        recyclerView.adapter = adapter

    }

    private fun getInfo() {

        DetailService.getListDetailData(id) { status, data ->
            runOnUiThread {
                when (status) {
                    Status.SUCCESSFUL -> {
                        init()
                        list=ArrayList(data?.playlist?.tracks)
                        updateInfo()

                    }
                    Status.WRONG -> Toast.makeText(
                            this,
                            "猜猜是谁又出错了呢（）",
                            Toast.LENGTH_SHORT
                    ).show()


                    //请求到的数据为空时
                    Status.OTHER -> Toast.makeText(
                            this,
                            "详情没获取到，总之先道个歉",
                            Toast.LENGTH_SHORT
                    ).show()


                }
            }

        }

    }

    private fun updateInfo() {
        adapter.getInfo(list)


    }

}