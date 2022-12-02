package az.ekvileptika.data

import az.ekvileptika.data.characters.ResponseModel
import retrofit2.http.GET

interface RetrofitApi {
    @GET("character")
    suspend fun getInfo(): ResponseModel
}