package com.rahmat.app.imgevwer.features.image

import com.rahmat.app.imgevwer.entity.Image
import com.rahmat.app.imgevwer.features.base.BaseContract

/**
 * Created by muhrahmatullah on 12/10/18.
 */
interface ImageContract {

    interface View: BaseContract.View{
        fun showImage(catList: List<Image>)
    }

    interface Presenter: BaseContract.Presenter{
        fun initImage()
    }

}