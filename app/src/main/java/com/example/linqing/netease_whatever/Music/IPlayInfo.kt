package com.example.linqing.netease_whatever.Music

interface IPlayInfo {

    /*用于更新标题栏变化*/
     fun onMusicInfoChanged(musicName: String, musicAuthor: String)

    /*用于更新背景图片*/
     fun onMusicPicChanged(musicPicRes: Int)

    /*用于更新音乐播放状态*/
     fun onMusicChanged(musicChangedStatus: DiscStatus)


}