package com.example.linqing.netease_whatever.ListDetail

import com.example.linqing.netease_whatever.Sevice.MainService
import com.example.linqing.netease_whatever.Sevice.Status
import kotlinx.coroutines.launch

object DetailService {

    fun getListDetailData(id: Int, back: (Status, DetailBean?) -> (Unit)) {
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

            }
        }

    }
}