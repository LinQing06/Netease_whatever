package com.example.linqing.netease_whatever.View

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.linqing.netease_whatever.Model.Share
import com.example.linqing.netease_whatever.Model.Status
import com.example.linqing.netease_whatever.R
import com.example.linqing.netease_whatever.Service.LoginService
import com.example.linqing.netease_whatever.Service.MainService
import kotlinx.android.synthetic.main.login_two.*
import kotlinx.coroutines.android.UI
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity


class LoginActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.login_two)

        back_button.setOnClickListener(){
            finish()
        }
        login_button.setOnClickListener() {


            if (phoneNumber.text.toString() == "") {
                Toast.makeText(this, "你不填电话号怎么登陆？嗯？", Toast.LENGTH_SHORT).show()
            }

            else {
                LoginService.login(phoneNumber.text.toString(), passwordInput.text.toString()) { status, data ->
                    runOnUiThread {


                        when (status) {
                            Status.SUCCESSFUL -> {
                                Toast.makeText(this, "登陆成功了，真是可喜可贺，可喜可贺${data!!.profile?.nickname}", Toast.LENGTH_SHORT).show()
                                val share = getSharedPreferences("data", Context.MODE_PRIVATE)
                                Share.userInfo(
                                        share,
                                        data,
                                        phoneNumber.text.toString(),
                                        passwordInput.text.toString()
                                )


                                startActivity<MainActivity>()


                                finish()
                            }


                            Status.WRONG -> Toast.makeText(
                                    this,
                                    "密码错了喔baby",
                                    Toast.LENGTH_SHORT
                            ).show()


                            Status.OTHER -> Toast.makeText(
                                    this,
                                    "唔，似乎发生了什么问题，一定不是开发者的错！（确信）",
                                    Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }

        }
    }
}

