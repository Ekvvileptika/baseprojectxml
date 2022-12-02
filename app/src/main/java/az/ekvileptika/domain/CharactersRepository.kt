package az.ekvileptika.domain

import az.ekvileptika.data.characters.ResponseModel
import az.ekvileptika.utils.ResponseResources

interface CharactersRepository {
    suspend fun getAllCharacters(): ResponseResources<ResponseModel>
}