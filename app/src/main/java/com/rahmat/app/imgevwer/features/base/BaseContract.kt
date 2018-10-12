package com.rahmat.app.imgevwer.features.base

/**
 * Created by muhrahmatullah on 12/10/18.
 */
interface BaseContract {

    interface View{

        fun showLoading()

        fun hideLoading()

        fun onError(message: String)

        fun showMessage(message: String)
    }

    interface Presenter{

    }


}