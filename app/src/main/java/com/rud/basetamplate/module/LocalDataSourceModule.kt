package com.rud.basetamplate.module

import com.rud.basetamplate.data.local.MovieDatabase
import com.rud.basetamplate.data.local.MovieLocalDataSource
import org.koin.dsl.module.applicationContext

val localDataSourceModule = applicationContext {

    factory { MovieLocalDataSource(get()) }
    factory { MovieDatabase.getInstance(get()) }
}