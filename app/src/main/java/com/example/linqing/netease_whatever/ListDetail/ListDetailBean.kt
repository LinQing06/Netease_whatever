package com.example.linqing.netease_whatever.ListDetail

data class DetailBean(
    val code: Int,
    val playlist: Playlist,
    val privileges: List<Privilege>
)

data class Privilege(
    val cp: Int,
    val cs: Boolean,
    val dl: Int,
    val fee: Int,
    val fl: Int,
    val flag: Int,
    val id: Int,
    val maxbr: Int,
    val payed: Int,
    val pl: Int,
    val preSell: Boolean,
    val sp: Int,
    val st: Int,
    val subp: Int,
    val toast: Boolean
)

data class Playlist(
    val adType: Int,
    val cloudTrackCount: Int,
    val commentCount: Int,
    val commentThreadId: String,
    val coverImgId: Long,
    val coverImgUrl: String,
    val createTime: Long,
    val creator: Creator,
    val description: String,
    val highQuality: Boolean,
    val id: String,//java.lang.NumberFormatException，JsonSyntaxException
    val name: String,
    val newImported: Boolean,
    val ordered: Boolean,
    val playCount: Int,
    val privacy: Int,
    val shareCount: Int,
    val specialType: Int,
    val status: Int,
    val subscribed: Boolean,
    val subscribedCount: Int,
    val subscribers: List<Subscriber>,
    val tags: List<String>,
    val trackCount: Int,
    val trackIds: List<TrackId>,
    val trackNumberUpdateTime: Long,
    val trackUpdateTime: Long,
    val tracks: List<Track>,
    val updateTime: Long,
    val userId: Int
)

data class Creator(
    val accountStatus: Int,
    val authStatus: Int,
    val authority: Int,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Long,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val expertTags: Any,
    val experts: Any,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val remarkName: Any,
    val signature: String,
    val userId: Int,
    val userType: Int,
    val vipType: Int
)

data class Track(
    val a: Any,
    val al: Al,//专辑id+专辑名字+图片url
    val alia: List<Any>,
    val ar: List<Ar>,//作者id+author名字
    val cd: String,
    val cf: String,
    val copyright: Int,
    val cp: Int,
    val crbt: Any,
    val djId: Int,
    val dt: Int,
    val fee: Int,
    val ftype: Int,
    val h: H,
    val id: String,//这个应该是歌曲的id//改一改
    val l: L,
    val m: M,
    val mst: Int,
    val mv: Int,
    val name: String,//歌曲名字
    val no: Int,
    val pop: Int,
    val pst: Int,
    val publishTime: Long,
    val rt: String,
    val rtUrl: Any,
    val rtUrls: List<Any>,
    val rtype: Int,
    val rurl: Any,
    val s_id: Int,
    val st: Int,
    val t: Int,
    val tns: List<String>,
    val v: Int
)

data class M(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Float
)

data class H(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Float
)

data class Al(//专辑信息
    val id: Int,
    val name: String,
    val pic: Long,
    val picUrl: String,
    val tns: List<String>
)

data class Ar(//作者信息
    val alias: List<Any>,
    val id: Int,
    val name: String,
    val tns: List<Any>
)

data class L(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Float
)

data class TrackId(
    val id: Int,
    val v: Int
)

data class Subscriber(
    val accountStatus: Int,
    val authStatus: Int,
    val authority: Int,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Long,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val expertTags: Any,
    val experts: Any,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val remarkName: Any,
    val signature: String,
    val userId: Int,
    val userType: Int,
    val vipType: Int
)