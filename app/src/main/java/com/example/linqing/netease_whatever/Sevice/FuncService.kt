package com.example.linqing.netease_whatever.Sevice

import com.example.linqing.netease_whatever.ListDetail.DetailBean
import com.example.linqing.netease_whatever.Login.LoginBean
import com.example.linqing.netease_whatever.PlayList.MyPLaylistBean
import kotlinx.coroutines.launch

object FuncService {


    fun login(phone: String, password: String, logData: (Status, LoginBean?) -> (Unit)) {

        val call = MainService.getLogin(phone,password)
        launch {
            try {
                val loginDataBean = call.execute().body()
                if (loginDataBean == null)
                    logData(Status.WRONG, null)
                else
                    logData(Status.SUCCESSFUL, loginDataBean)
            } catch (e: Exception) {
                logData(Status.OTHER, null)
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

    //添加除了登陆的其他service

    //列表
    fun getListData(id:Int,back:(Status, MyPLaylistBean?)->(Unit)){
        val call =MainService.getListData(id)
        object :Thread(){
            override fun run() {
                try {
                    val MyPLaylistBean=call.execute().body()
                    if (MyPLaylistBean==null)back(Status.OTHER,MyPLaylistBean)
                    else back(Status.SUCCESSFUL,MyPLaylistBean)

                }catch (e: Exception){
                    e.printStackTrace()
                    back(Status.WRONG,null)
                }
            }
        }.start()
    }
    //歌单详情

    fun getListDetailData(id:Int,back:(Status, DetailBean?)->(Unit)){
        val call =MainService.getDetailData(id)
        object :Thread(){
            override fun run() {
                try {
                    val DetailBean=call.execute().body()
                    if (DetailBean==null)back(Status.OTHER, DetailBean)
                    else back(Status.SUCCESSFUL, DetailBean)

                }catch (e: Exception){
                    e.printStackTrace()
                    back(Status.WRONG,null)
                }
            }
        }.start()
    }




}