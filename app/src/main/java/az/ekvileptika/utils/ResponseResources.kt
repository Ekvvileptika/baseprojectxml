package az.ekvileptika.utils

sealed class ResponseResources<T>(val data: T?, val message: String?){
    class Success<T>(data: T, message: String? = null): ResponseResources<T>(data, null)
    class Failure<T>(data: T? = null, message: String?): ResponseResources<T>(null, message)
    class Loading<T>(data: T? = null, message: String? = null): ResponseResources<T>(null, null)
}
