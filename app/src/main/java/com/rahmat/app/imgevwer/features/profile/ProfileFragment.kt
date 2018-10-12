package com.rahmat.app.imgevwer.features.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.data.preference.PreferenceHelper
import com.rahmat.app.imgevwer.features.base.BaseFragment
import com.rahmat.app.imgevwer.features.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class ProfileFragment: BaseFragment<ProfilePresenter, ProfileContract.View>(), ProfileContract.View {

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnLogout.setOnClickListener {
            mPresenter.removeUser()
        }
    }

    override fun createPresenter(): ProfilePresenter {
        return ProfilePresenter(preferenceHelper)
    }

    override fun toLogin() {
        activity?.startActivity<LoginActivity>()
        activity?.finish()
    }
}