package com.example.linqing.netease_whatever.Service

import com.example.linqing.netease_whatever.Model.Bean.LoginBean
import com.example.linqing.netease_whatever.Model.Status
import kotlinx.coroutines.launch

object LoginService {

    fun login(phone: String, password: String, logData: (Status, LoginBean?) -> (Unit)) {

        val call = MainService.getLogin(phone,password)
        launch {
            try {
                val loginDataBean = call.execute().body()
                if (loginDataBean == null)
                    logData(Status.OTHER, null)
                else
                    logData(Status.SUCCESSFUL, loginDataBean)
            } catch (e: Exception) {
                logData(Status.WRONG, null)
                e.printStackTrace()
            }
        }
    }

    fun logout() {
        val call = MainService.logout()
        launch {
            call.execute().body()
        }
    }


}