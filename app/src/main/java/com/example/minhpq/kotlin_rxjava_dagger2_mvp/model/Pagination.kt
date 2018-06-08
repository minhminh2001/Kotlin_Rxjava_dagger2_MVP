package com.example.minhpq.kotlin_rxjava_dagger2_mvp.model

import com.google.gson.annotations.SerializedName

class Pagination {
    @SerializedName("TotalPages")
    var TotalPages :String?=null
    @SerializedName("PageNo")
    var PageNo :String?=null
    @SerializedName("PerPage")
    var PerPage :String?=null
    @SerializedName("WebURL")
    var WebURL :String?=null

    constructor(TotalPages: String?, PageNo: String?, PerPage: String?, WebURL: String?) {
        this.TotalPages = TotalPages
        this.PageNo = PageNo
        this.PerPage = PerPage
        this.WebURL = WebURL
    }
}