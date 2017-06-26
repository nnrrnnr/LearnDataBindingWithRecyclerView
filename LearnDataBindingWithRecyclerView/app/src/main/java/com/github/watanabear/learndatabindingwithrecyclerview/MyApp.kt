package com.github.watanabear.learndatabindingwithrecyclerview

import android.app.Application
import com.github.watanabear.learndatabindingwithrecyclerview.di.ApplicationComponent
import com.github.watanabear.learndatabindingwithrecyclerview.di.ApplicationModule
import com.github.watanabear.learndatabindingwithrecyclerview.di.DaggerApplicationComponent
import timber.log.Timber

/**
 * Created by ryo on 2017/06/23.
 */
class MyApp: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}