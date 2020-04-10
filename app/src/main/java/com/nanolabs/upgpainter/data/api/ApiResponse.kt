package com.nanolabs.upgpainter.data.api

import com.google.gson.annotations.SerializedName
import com.nanolabs.upgpainter.data.data.ItemData

class ApiResponse {

    @SerializedName("name")
    var getName:String?=null

    @SerializedName("image")
    var getImage:String?=null


    @SerializedName("headerTitle")
    var getHeaderTitle:String?=null

    @SerializedName("MyData")
    var getMyData:ArrayList<String>?=null

    @SerializedName("listItem")
    var getListItem:ArrayList<ItemData>?=null

}