package com.rahmat.app.imgevwer.di.injector

import com.rahmat.app.imgevwer.ImageViewerApp
import com.rahmat.app.imgevwer.di.component.DaggerAppComponent

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class AppInjector {

    companion object {
        fun init(application: ImageViewerApp) {
            DaggerAppComponent
                    .builder()
                    .application(application)
                    .build()
                    .inject(application)
        }
    }
}