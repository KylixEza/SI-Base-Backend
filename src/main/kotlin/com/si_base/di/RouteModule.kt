package com.si_base.di

import com.si_base.route.SIBaseRoute
import org.koin.dsl.module

val routeModule = module {
    single { SIBaseRoute(get()) }
}