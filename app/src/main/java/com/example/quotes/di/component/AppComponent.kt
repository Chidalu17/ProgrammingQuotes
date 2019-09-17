package com.example.quotes.di.component

import android.app.Application
import com.example.quotes.BaseApplication
import com.example.quotes.di.builders.ActivityBuilder
import com.example.quotes.di.modules.AppModule
import com.example.quotes.di.modules.ContextModule
import com.example.quotes.di.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ContextModule::class,
    ActivityBuilder::class,
    RetrofitModule::class])
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(application: BaseApplication)



}
