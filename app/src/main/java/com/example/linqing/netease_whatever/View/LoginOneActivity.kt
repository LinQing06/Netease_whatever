package com.example.linqing.netease_whatever.View

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.linqing.netease_whatever.R
import kotlinx.android.synthetic.main.login_one.*
import org.jetbrains.anko.startActivity

class LoginOneActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.login_one)
        login_one_button.setOnClickListener {
            startActivity<LoginActivity>()
        }
    }
}