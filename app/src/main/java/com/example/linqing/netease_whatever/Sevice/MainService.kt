package com.example.linqing.netease_whatever.Sevice

import com.example.linqing.netease_whatever.ListDetail.DetailBean
import com.example.linqing.netease_whatever.ListDetail.ListDetailAdapter
import com.example.linqing.netease_whatever.Login.LoginBean
import com.example.linqing.netease_whatever.PlayList.MyPLaylistBean
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService{

    @GET("/login/cellphone")

    fun getLogin(@Query("phone") phoneNum: String, @Query("password") passWord: String): Call<LoginBean>

   // @GET("/logout")
   // fun logout(): Call<ResponseBody>


    @GET("/user/playlist")
    fun getListData(@Query("uid") uid: Int?): Call<MyPLaylistBean>


    @GET("/playlist/detail?")
    fun getDetailData(@Query("id") id: Int?): Call<DetailBean>

    companion object : MainService by NetModel()
}
