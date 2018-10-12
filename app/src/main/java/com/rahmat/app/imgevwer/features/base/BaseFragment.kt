package com.rahmat.app.imgevwer.features.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import dagger.android.support.AndroidSupportInjection

/**
 * Created by muhrahmatullah on 12/10/18.
 */
abstract class BaseFragment<P : BasePresenter<V>, V : BaseContract.View> : Fragment(),
        BaseContract.View {

    protected lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        mPresenter = createPresenter()

        @Suppress("UNCHECKED_CAST")
        mPresenter.attachView(this as V)
    }

    protected abstract fun createPresenter(): P

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(message: String) {
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}