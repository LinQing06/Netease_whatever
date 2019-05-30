package com.example.linqing.netease_whatever.ListDetail

import android.util.Log
import com.example.linqing.netease_whatever.Sevice.MainService
import com.example.linqing.netease_whatever.Sevice.Status
import kotlinx.coroutines.launch
import kotlin.math.log

object DetailService {

    fun getListDetailData(id: String, back: (Status, DetailBean?) -> (Unit)) {
        val call = MainService.getDetailData(id)
        launch {
            try {
                val listInfoData = call.execute().body()
                if (listInfoData == null)
                    back(Status.OTHER, null)
                else
                    back(Status.SUCCESSFUL, listInfoData)
            } catch (e: Exception) {
                back(Status.WRONG, null)
                e.printStackTrace()
                Log.d("aaa",e.toString())
            }
        }

    }
}