package com.example.linqing.netease_whatever.Service

import com.example.linqing.netease_whatever.Model.Bean.LoginBean
import com.example.linqing.netease_whatever.Model.NetModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService{

    @GET("/login/cellphone")

    fun getLogin(@Query("phone") phoneNum: String, @Query("password") passWord: String):
            Call<LoginBean>

    @GET("/logout")

    fun logout():
            Call<ResponseBody>

    companion object : MainService by NetModel()
}
