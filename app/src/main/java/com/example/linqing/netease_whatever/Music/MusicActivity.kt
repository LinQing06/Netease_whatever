package com.example.linqing.netease_whatever.Music

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.linqing.netease_whatever.R

class MusicActivity : AppCompatActivity() {
    internal var id = ""
    internal var author = ""
    internal var musicName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.music_disc)
        var intent = intent
        id = intent.getStringExtra("id")
        author=intent.getStringExtra("author")
        musicName=intent.getStringExtra("musicName")


    }


}