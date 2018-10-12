package com.rahmat.app.imgevwer.features.base

/**
 * Created by muhrahmatullah on 12/10/18.
 */
abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter{

    protected var mView: V? = null

    protected val isViewAttached: Boolean
        get() = mView != null

    fun attachView(view: V) {
        mView = view
    }

    fun detachView() {
        mView = null
    }
}