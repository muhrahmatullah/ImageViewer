package com.rahmat.app.imgevwer.di.module

import com.rahmat.app.imgevwer.features.detailimage.DetailActivity
import com.rahmat.app.imgevwer.features.image.ImageFragment
import com.rahmat.app.imgevwer.features.login.LoginActivity
import com.rahmat.app.imgevwer.features.main.MainActivity
import com.rahmat.app.imgevwer.features.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by muhrahmatullah on 12/10/18.
 */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity() : LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity() : DetailActivity

    @ContributesAndroidInjector
    abstract fun contributeImageFragment() : ImageFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment() : ProfileFragment


}