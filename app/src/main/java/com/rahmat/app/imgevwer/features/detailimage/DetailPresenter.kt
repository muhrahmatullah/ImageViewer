package com.rahmat.app.imgevwer.features.detailimage

import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.features.base.BasePresenter

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class DetailPresenter: BasePresenter<DetailContract.View>(), DetailContract.Presenter {

    var url_maps = HashMap<String, Int>()

    override fun initSlider() {
        url_maps.put("The Handsome Cat", R.drawable.img_cat)
        url_maps.put("The Black Cat", R.drawable.img_black)
        url_maps.put("The Cute Cat", R.drawable.img_cat_cute)

        mView?.displaySlider(url_maps)
    }
}