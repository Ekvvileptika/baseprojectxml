package az.ekvileptika.data.characters

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel (
    @SerialName("results")
    val results: List<CharactersModel>
)

@Serializable
data class CharactersModel(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("image")
    val image: String
)

