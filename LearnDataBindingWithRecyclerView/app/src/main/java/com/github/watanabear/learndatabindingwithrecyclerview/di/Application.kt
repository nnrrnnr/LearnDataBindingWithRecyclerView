package com.github.watanabear.learndatabindingwithrecyclerview.di

import android.content.Context
import com.github.gfx.android.orma.AccessThreadConstraint
import com.github.watanabear.learndatabindingwithrecyclerview.MyApp
import com.github.watanabear.learndatabindingwithrecyclerview.api.GithubService
import com.github.watanabear.learndatabindingwithrecyclerview.domain.OrmaDatabase
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

/**
 * Created by ryo on 2017/06/23.
 */
@Module
class ApplicationModule(private val application: MyApp) {

    private val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Provides
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideOkHttp(): OkHttpClient {
        val log = HttpLoggingInterceptor { log -> Timber.tag("OkHttp").v(log) }
        log.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().addInterceptor(log).build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    fun provideGitHubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

    @Provides
    fun provideOrma(context: Context): OrmaHolder {
        val orma = OrmaDatabase.builder(context)
                .writeOnMainThread(AccessThreadConstraint.FATAL)
                .readOnMainThread(AccessThreadConstraint.FATAL)
                .trace(true)
                .build()
        return OrmaHolder(orma)
    }


    class OrmaHolder(val orma: OrmaDatabase)
}

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun plus(m: UserListModule): UserListComponent
}