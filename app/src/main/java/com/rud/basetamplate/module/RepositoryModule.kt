package com.rud.basetamplate.module

import com.rud.basetamplate.data.MovieRepository
import org.koin.dsl.module.applicationContext

val repositoryModule = applicationContext {
    factory { MovieRepository(get(), get()) }
}