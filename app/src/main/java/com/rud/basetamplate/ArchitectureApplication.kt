package com.rud.basetamplate

import android.app.Application
import com.rud.basetamplate.module.localDataSourceModule
import com.rud.basetamplate.module.remoteDatasourceModule
import com.rud.basetamplate.module.repositoryModule
import com.rud.basetamplate.module.viewModelModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class ArchitectureApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        startKoin(this, listOf(
                remoteDatasourceModule,
                localDataSourceModule,
                repositoryModule,
                viewModelModule))
    }
}