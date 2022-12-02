package az.ekvileptika.data.characters

import az.ekvileptika.data.RetrofitApi
import az.ekvileptika.di.NetworkModule
import az.ekvileptika.domain.CharactersRepository
import az.ekvileptika.utils.ResponseResources
import java.lang.Exception
import javax.inject.Inject


class CharactersRepositoryImpl @Inject constructor(
    val api: RetrofitApi
): CharactersRepository {
    override suspend fun getAllCharacters(): ResponseResources<ResponseModel> {
        return try {
            val response = api.getInfo()
            ResponseResources.Success(response)
        } catch (ex: Exception){
            ResponseResources.Failure(message = ex.localizedMessage, data = null)
        }
    }
}