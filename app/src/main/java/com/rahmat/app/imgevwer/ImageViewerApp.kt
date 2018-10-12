package com.rahmat.app.imgevwer

import android.app.Activity
import android.app.Application
import com.rahmat.app.imgevwer.di.injector.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class ImageViewerApp : Application(), HasActivityInjector {

    @Inject
    lateinit var mActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return mActivityInjector
    }

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/openSans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build())
    }
}