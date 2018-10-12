package com.rahmat.app.imgevwer.di.component

import android.app.Application
import com.rahmat.app.imgevwer.ImageViewerApp
import com.rahmat.app.imgevwer.di.module.ActivityBuildersModule
import com.rahmat.app.imgevwer.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by muhrahmatullah on 12/10/18.
 */
@Singleton
@Component(modules = [(AppModule::class), (AndroidSupportInjectionModule::class), (ActivityBuildersModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: ImageViewerApp)

}