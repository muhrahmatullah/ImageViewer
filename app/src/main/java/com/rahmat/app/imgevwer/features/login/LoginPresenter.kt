package com.rahmat.app.imgevwer.features.login

import com.rahmat.app.imgevwer.data.preference.PreferenceHelper
import com.rahmat.app.imgevwer.features.base.BasePresenter

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class LoginPresenter(val preferenceHelper: PreferenceHelper) : BasePresenter<LoginContract.View>(), LoginContract.Presenter{

    override fun isLogedIn(log: Boolean){
        if (log){
            mView?.toMainActivity()
        }
    }

    override fun storeUser(email: String, password: String) {
        preferenceHelper.setUserEmail(email)
        preferenceHelper.setUserPassword(password)
        preferenceHelper.setLoggedIn(true)
        mView?.toMainActivity()
    }
}