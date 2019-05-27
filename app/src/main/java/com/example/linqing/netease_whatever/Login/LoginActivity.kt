package com.example.linqing.netease_whatever.Login

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.linqing.netease_whatever.Sevice.Share
import com.example.linqing.netease_whatever.Sevice.Status
import com.example.linqing.netease_whatever.R
import com.example.linqing.netease_whatever.PlayList.MainActivity
import kotlinx.android.synthetic.main.login_two.*
import org.jetbrains.anko.startActivity


class LoginActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.login_two)

        //想修一下弹窗效果，以后再补充8
        val builder = AlertDialog.Builder(this)

        back_button.setOnClickListener(){
            finish()
        }


        login_button.setOnClickListener() {


            if (phoneNumber.text.toString() == "") {
                Toast.makeText(this, "我可以拥有你的手机号🐎", Toast.LENGTH_SHORT).show()
            }

            else {
                LoginService.login(phoneNumber.text.toString(), passwordInput.text.toString()) { status, data ->
                    runOnUiThread {


                        when (status) {
                            Status.SUCCESSFUL -> {
                                Toast.makeText(this, "恭喜${data!!.profile?.nickname}同学登陆成功，掌声祝福", Toast.LENGTH_SHORT).show()
                                val share = getSharedPreferences("data", Context.MODE_PRIVATE)
                                Share.userInfo(
                                        share,
                                        data,
                                        phoneNumber.text.toString(),
                                        passwordInput.text.toString()
                                )


                                startActivity<MainActivity>("nickname" to data.profile?.nickname,"uid" to data.account.id)


                                finish()
                            }


                            Status.WRONG -> Toast.makeText(
                                    this,
                                    "密码错了（— —'）",
                                    Toast.LENGTH_SHORT
                            ).show()


                            Status.OTHER -> Toast.makeText(
                                    this,
                                    "不管是什么错总之我先道个歉",
                                    Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }

        }
    }
}

