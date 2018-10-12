package com.rahmat.app.imgevwer.features.image


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.features.base.BaseFragment

class ImageFragment : BaseFragment<ImagePresenter, ImageContract.View>(), ImageContract.View {

    override fun createPresenter(): ImagePresenter {
        return ImagePresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_image, container, false)
    }


}
