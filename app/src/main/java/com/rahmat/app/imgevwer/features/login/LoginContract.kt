package com.rahmat.app.imgevwer.features.login

import com.rahmat.app.imgevwer.features.base.BaseContract

/**
 * Created by muhrahmatullah on 12/10/18.
 */
interface LoginContract {

    interface View : BaseContract.View{
        fun toMainActivity()
    }

    interface Presenter : BaseContract.Presenter{
        fun isLogedIn(log: Boolean)
        fun storeUser(email: String, password: String)
    }

}