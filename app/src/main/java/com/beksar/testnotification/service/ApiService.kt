package com.timelysoft.tsjdomcom.service

import com.example.kotlinscreenscanner.service.model.CommonResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import kotlin.collections.ArrayList

interface ApiService {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST()
    suspend fun auth(@FieldMap params: Map<String, String>): Response<CommonResponse<String>>

}

