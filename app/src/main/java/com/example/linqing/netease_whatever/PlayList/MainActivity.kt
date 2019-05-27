package com.example.linqing.netease_whatever.PlayList

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.linqing.netease_whatever.R
import com.example.linqing.netease_whatever.Sevice.Status

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var list : ArrayList <Playlist?>
    internal var uid = 0
    private var nickname=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_main)
        var intent = intent
        uid = intent.getIntExtra("uid", 0)
        nickname=intent.getStringExtra("nickname")
        getView()

    }

    private fun init() {
        val linearLayout = LinearLayoutManager(this)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        adapter = ListAdapter(this)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = linearLayout
        recyclerView.adapter = adapter

    }

    private fun getView() {

        ListService.getList(uid) { status, data ->
            runOnUiThread {
                when (status) {
                    Status.SUCCESSFUL -> {
                        init()
                        list = ArrayList(data!!.playlist)
                        updateList()

                    }
                    Status.WRONG -> Toast.makeText(
                            this,
                            "目前是未知错误（）",
                            Toast.LENGTH_SHORT
                    ).show()


                    //请求到的为空时
                    Status.OTHER -> Toast.makeText(
                            this,
                            "好，又没请求到东西",
                            Toast.LENGTH_SHORT
                    ).show()


                }
            }

        }

    }

    private fun updateList() {
        adapter.getData(list,nickname)



    }
}
