package com.rahmat.app.imgevwer.features.profile

import com.rahmat.app.imgevwer.features.base.BaseContract

/**
 * Created by muhrahmatullah on 12/10/18.
 */
interface ProfileContract {

    interface View: BaseContract.View{
        fun toLogin()
    }

    interface Presenter: BaseContract.Presenter{
        fun removeUser()
    }

}