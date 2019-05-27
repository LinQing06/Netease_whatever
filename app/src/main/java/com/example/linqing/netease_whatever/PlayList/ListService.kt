package com.example.linqing.netease_whatever.PlayList

import android.os.Handler
import android.os.Looper
import com.example.linqing.netease_whatever.Sevice.MainService
import com.example.linqing.netease_whatever.Sevice.Status
import kotlinx.coroutines.launch

object ListService {

    fun getList(uid: Int,back: (Status, MyPLaylistBean?) -> Unit){
        val call= MainService.getListData(uid)
        launch {
            try {
                val listData=call.execute().body()
                val handler = Handler(Looper.getMainLooper())
//                handler.post {
                    if(listData==null)
                        back(Status.OTHER,null)
                    else
                        back(Status.SUCCESSFUL,listData)
//                }
            }catch (e:Exception){
                back(Status.WRONG,null)
                e.printStackTrace()

            }
        }

    }
}