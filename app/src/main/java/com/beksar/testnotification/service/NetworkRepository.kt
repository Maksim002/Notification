package com.timelysoft.tsjdomcom.service

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers


class NetworkRepository {

    fun auth(params: Map<String, String>) = liveData(Dispatchers.IO) {
        try {
            val response = RetrofitService.apiService().auth(params)
            when {
                response.isSuccessful -> {
                    if (response.body() != null) {
                        emit(ResultStatus.success(response.body()))
                    } else {
                        emit(ResultStatus.error("Неверный логин или пароль"))
                    }
                }else -> {
                    emit(ResultStatus.error(response.code().toString()))
                }
            }
        } catch (e: Exception) {
            if (e.localizedMessage != "End of input at line 1 column 1 path \$"){
                emit(ResultStatus.netwrok("601", null))
            }else{
                emit(ResultStatus.netwrok("600", null))
            }
        }
    }
}