package com.example.linqing.netease_whatever.Music

//需要触发的状态
enum class DiscStatus {
    PLAY,
    POUSE,
    NEXT,
    LAST,
    STOP

}
//播放状态
enum class PlayStatus{
    PLAY,
    PAUSE,
    STOP
}
//唱针的状态
enum class Needle{
    /*移动时：从唱盘往远处移动*/
    TO_FAR_END,
    /*移动时：从远处往唱盘移动*/
    TO_NEAR_END,
    /*静止时：离开唱盘*/
    IN_FAR_END,
    /*静止时：贴近唱盘*/
    IN_NEAR_END

}