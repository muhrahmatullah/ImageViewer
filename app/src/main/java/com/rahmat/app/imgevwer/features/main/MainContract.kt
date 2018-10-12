package com.rahmat.app.imgevwer.features.main

import android.os.Bundle
import com.rahmat.app.imgevwer.features.base.BaseContract

/**
 * Created by muhrahmatullah on 12/10/18.
 */
interface MainContract {
    interface View: BaseContract.View{
        fun loadHome(savedInstanceState: Bundle?)
        fun loadProfile(savedInstanceState: Bundle?)
    }

    interface Presenter: BaseContract.Presenter{

    }

}