package com.rahmat.app.imgevwer.features.profile

import com.rahmat.app.imgevwer.data.preference.PreferenceHelper
import com.rahmat.app.imgevwer.features.base.BasePresenter

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class ProfilePresenter(val preferenceHelper: PreferenceHelper): BasePresenter<ProfileContract.View>(), ProfileContract.Presenter {
    override fun removeUser() {
        preferenceHelper.clearSharedPref()
        mView?.toLogin()
    }
}