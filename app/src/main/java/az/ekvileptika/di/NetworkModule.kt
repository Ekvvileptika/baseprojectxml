package az.ekvileptika.di

import az.ekvileptika.data.RetrofitApi
import az.ekvileptika.utils.ApplicationSettings
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.annotations.NotNull
import retrofit2.Retrofit
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Singleton Provides]
    fun provideNetworkModule(
        clientOk: OkHttpClient
    ): RetrofitApi{
        val contentType = "application/json".toMediaTypeOrNull()
        val json = Json{ ignoreUnknownKeys = true  }.asConverterFactory(contentType!!)

        return Retrofit.Builder()
            .baseUrl(ApplicationSettings.baseUrl)
            .client(clientOk)
            .addConverterFactory(json)
            .build()
            .create(RetrofitApi::class.java)
    }


    @[ Singleton Provides NotNull]
    fun provideOkHttpClient(): OkHttpClient {
        val okhttp = OkHttpClient().newBuilder()

        //Logging requests
        val httpLoggingInterceptor = HttpLoggingInterceptor { message: String? ->
            Timber.i(message)
        }
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        okhttp.addInterceptor(httpLoggingInterceptor)

        okhttp.readTimeout(ApplicationSettings.timeout, TimeUnit.SECONDS)
        okhttp.writeTimeout(ApplicationSettings.timeout, TimeUnit.SECONDS)
        okhttp.connectTimeout(ApplicationSettings.timeout, TimeUnit.SECONDS)


        return okhttp.build()
    }
}