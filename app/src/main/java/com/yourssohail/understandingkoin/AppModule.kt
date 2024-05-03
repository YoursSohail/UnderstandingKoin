package com.yourssohail.understandingkoin

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
//    single<EmployeeRepository> { EmployeeRepositoryImpl() }
    singleOf(::EmployeeRepositoryImpl){ bind<EmployeeRepository>() }
//    viewModel {
//        EmployeeViewModel(get())
//    }
    viewModelOf(::EmployeeViewModel)
//    factory<EmployeeFactory> { EmployeeFactory(get()) }
    factoryOf(::EmployeeFactory)
}