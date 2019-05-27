package com.example.linqing.netease_whatever.Music

data class MusicBean(
    val `data`: List<Data>,
    val code: Int
)

data class Data(
    val br: Int,
    val canExtend: Boolean,
    val code: Int,
    val encodeType: String,
    val expi: Int,
    val fee: Int,
    val flag: Int,
    val freeTrialInfo: Any,
    val gain: Int,
    val id: Int,
    val level: String,
    val md5: String,
    val payed: Int,
    val size: Int,
    val type: String,
    val uf: Any,
    val url: String
)