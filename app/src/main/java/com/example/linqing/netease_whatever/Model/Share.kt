package com.example.linqing.netease_whatever.Model

import android.content.SharedPreferences
import com.example.linqing.netease_whatever.Model.Bean.LoginBean

object Share {

    fun userInfo(s: SharedPreferences, i: LoginBean, ph: String, pwd: String) {
        s.edit()
                .putString("avatar_url", i.profile?.avatarUrl)
                .putString("nickname", i.profile?.nickname)
                .putInt("gender", i.profile?.gender ?: 0)
                .putString("phoneNumber", ph)
                .putString("password", pwd)
                .putInt("id", i.account?.id ?: 0)
                .putString("background_url", i.profile?.backgroundUrl).apply()
    }
}