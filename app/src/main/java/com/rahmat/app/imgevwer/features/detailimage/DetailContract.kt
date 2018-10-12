package com.rahmat.app.imgevwer.features.detailimage

import com.rahmat.app.imgevwer.features.base.BaseContract

/**
 * Created by muhrahmatullah on 12/10/18.
 */
interface DetailContract {


    interface View: BaseContract.View{
        fun displaySlider(cat: HashMap<String, Int>)
    }

    interface Presenter: BaseContract.Presenter{
        fun initSlider()
    }

}