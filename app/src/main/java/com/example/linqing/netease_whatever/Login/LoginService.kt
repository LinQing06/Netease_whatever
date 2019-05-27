package com.example.linqing.netease_whatever.Login

import com.example.linqing.netease_whatever.ListDetail.DetailBean
import com.example.linqing.netease_whatever.Sevice.MainService
import com.example.linqing.netease_whatever.Sevice.Status
import kotlinx.coroutines.launch

object LoginService {


    fun login(phone: String, password: String, back: (Status, LoginBean?) -> (Unit)) {

        val call = MainService.getLogin(phone,password)
        launch {
            try {
                val loginData = call.execute().body()
                if (loginData == null)
                    back(Status.WRONG, null)
                else
                    back(Status.SUCCESSFUL, loginData)
            } catch (e: Exception) {
                back(Status.OTHER, null)
                e.printStackTrace()
            }
        }
    }
//logout

    //歌单详情







}