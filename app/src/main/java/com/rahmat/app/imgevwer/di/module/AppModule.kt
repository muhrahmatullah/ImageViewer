package com.rahmat.app.imgevwer.di.module

import android.app.Activity
import android.app.Application
import android.content.Context
import com.rahmat.app.imgevwer.data.preference.PreferenceHelper
import com.rahmat.app.imgevwer.data.preference.PreferenceHelperImp
import com.rahmat.app.imgevwer.di.ActivityContext
import com.rahmat.app.imgevwer.di.ApplicationContext
import com.rahmat.app.imgevwer.di.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by muhrahmatullah on 12/10/18.
 */
@Module
@Suppress("unused")
class AppModule {

    @Provides
    @ApplicationContext
    @Singleton
    internal fun provideApplicationContext(application: Application) : Context = application

    @Provides
    @ActivityContext
    @Singleton
    internal fun provideActivityContext(activity: Activity) : Context = activity

    @Provides
    @PreferenceInfo
    internal fun providePrefName(): String = "imgvwr_pref"

    @Provides
    @Singleton
    internal fun providePrefHelper(preferenceHelperImp: PreferenceHelperImp):
            PreferenceHelper = preferenceHelperImp

}