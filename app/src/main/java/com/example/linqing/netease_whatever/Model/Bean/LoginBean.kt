package com.example.linqing.netease_whatever.Model.Bean

class LoginBean {


    /**
     * loginType : 1
     * code : 200
     * account : {"id":305410963,"userName":"1_13820229070","type":1,"status":0,"whitelistAuthority":0,"createTime":1468765792092,"salt":"[B@525a5a5","tokenVersion":1,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false}
     * profile : {"userId":305410963,"avatarImgId":109951163836615760,"accountStatus":0,"province":110000,"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"avatarImgIdStr":"109951163836615764","backgroundImgIdStr":"109951163836620633","city":110101,"detailDescription":"","followed":false,"vipType":0,"gender":2,"birthday":960249009557,"nickname":"那边的人快住手","experts":{},"backgroundImgId":109951163836620640,"userType":0,"defaultAvatar":false,"avatarUrl":"https://p1.music.126.net/Jm-cuSGPiDZ3bAbNTju4Nw==/109951163836615764.jpg","backgroundUrl":"https://p1.music.126.net/iAYUQuR30uEeLtaGZLkp8A==/109951163836620633.jpg","djStatus":0,"description":"","signature":"奇杰太甜啦!","authority":0,"avatarImgId_str":"109951163836615764","followeds":11,"follows":4,"eventCount":0,"playlistCount":11,"playlistBeSubscribedCount":0}
     * bindings : [{"expired":false,"refreshTime":1468765816,"userId":305410963,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"13820229070\",\"hasPassword\":true}","expiresIn":2147483647,"url":"","bindingTime":1468765816369,"id":2878865118,"type":1},{"expired":true,"refreshTime":1545481192,"userId":305410963,"tokenJsonStr":"{\"access_token\":\"EA92076EE7AECFE2BBCCA4ED4A9574BD\",\"refresh_token\":\"F623B1824EA69F3A169D8C967C46928B\",\"openid\":\"53A7BC17C1588E1E0ACE3E605AF15AA6\",\"nickname\":\"百里长生\",\"expires_in\":7776000}","expiresIn":7776000,"url":"","bindingTime":1468765792260,"id":2878769480,"type":5}]
     */

    var loginType: Int = 0
    var code: Int = 0
    var account: AccountBean? = null
    var profile: ProfileBean? = null
    var bindings: List<BindingsBean>? = null

    class AccountBean {
        /**
         * id : 305410963
         * userName : 1_13820229070
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 1468765792092
         * salt : [B@525a5a5
         * tokenVersion : 1
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         */

        var id: Int = 0
        var userName: String? = null
        var type: Int = 0
        var status: Int = 0
        var whitelistAuthority: Int = 0
        var createTime: Long = 0
        var salt: String? = null
        var tokenVersion: Int = 0
        var ban: Int = 0
        var baoyueVersion: Int = 0
        var donateVersion: Int = 0
        var vipType: Int = 0
        var viptypeVersion: Int = 0
        var anonimousUser: Boolean = false
    }

    class ProfileBean {
        /**
         * userId : 305410963
         * avatarImgId : 109951163836615760
         * accountStatus : 0
         * province : 110000
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * avatarImgIdStr : 109951163836615764
         * backgroundImgIdStr : 109951163836620633
         * city : 110101
         * detailDescription :
         * followed : false
         * vipType : 0
         * gender : 2
         * birthday : 960249009557
         * nickname : 那边的人快住手
         * experts : {}
         * backgroundImgId : 109951163836620640
         * userType : 0
         * defaultAvatar : false
         * avatarUrl : https://p1.music.126.net/Jm-cuSGPiDZ3bAbNTju4Nw==/109951163836615764.jpg
         * backgroundUrl : https://p1.music.126.net/iAYUQuR30uEeLtaGZLkp8A==/109951163836620633.jpg
         * djStatus : 0
         * description :
         * signature : 奇杰太甜啦!
         * authority : 0
         * avatarImgId_str : 109951163836615764
         * followeds : 11
         * follows : 4
         * eventCount : 0
         * playlistCount : 11
         * playlistBeSubscribedCount : 0
         */

        var userId: Int = 0
        var avatarImgId: Long = 0
        var accountStatus: Int = 0
        var province: Int = 0
        var mutual: Boolean = false
        var remarkName: Any? = null
        var expertTags: Any? = null
        var authStatus: Int = 0
        var avatarImgIdStr: String? = null
        var backgroundImgIdStr: String? = null
        var city: Int = 0
        var detailDescription: String? = null
        var followed: Boolean = false
        var vipType: Int = 0
        var gender: Int = 0
        var birthday: Long = 0
        var nickname: String? = null
        var experts: ExpertsBean? = null
        var backgroundImgId: Long = 0
        var userType: Int = 0
        var defaultAvatar: Boolean = false
        var avatarUrl: String? = null
        var backgroundUrl: String? = null
        var djStatus: Int = 0
        var description: String? = null
        var signature: String? = null
        var authority: Int = 0
        var avatarImgId_str: String? = null
        var followeds: Int = 0
        var follows: Int = 0
        var eventCount: Int = 0
        var playlistCount: Int = 0
        var playlistBeSubscribedCount: Int = 0

        class ExpertsBean
    }

    class BindingsBean {
        /**
         * expired : false
         * refreshTime : 1468765816
         * userId : 305410963
         * tokenJsonStr : {"countrycode":"","cellphone":"13820229070","hasPassword":true}
         * expiresIn : 2147483647
         * url :
         * bindingTime : 1468765816369
         * id : 2878865118
         * type : 1
         */

        var expired: Boolean = false
        var refreshTime: Int = 0
        var userId: Int = 0
        var tokenJsonStr: String? = null
        var expiresIn: Int = 0
        var url: String? = null
        var bindingTime: Long = 0
        var id: Long = 0
        var type: Int = 0
    }
}
