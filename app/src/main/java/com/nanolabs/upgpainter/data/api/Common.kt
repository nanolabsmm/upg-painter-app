package com.nanolabs.upgpainter.data.api

object Common {
    private const val BASE_URL = "http://45.32.110.15/"


    val api: ApiInterface
        get() = ApiClient.getClient(BASE_URL).create(ApiInterface::class.java )
}