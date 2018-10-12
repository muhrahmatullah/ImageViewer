package com.rahmat.app.imgevwer.features.image


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.entity.Image
import com.rahmat.app.imgevwer.features.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment : BaseFragment<ImagePresenter, ImageContract.View>(), ImageContract.View {

    private var imageList: MutableList<Image> = mutableListOf()

    override fun showImage(catList: List<Image>) {
        imageList.addAll(catList)
        Log.v("test", imageList.size.toString())
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvImage.layoutManager = layoutManager
        rvImage.adapter = ImageAdapter(imageList)
    }

    override fun createPresenter(): ImagePresenter {
        return ImagePresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.initImage()

    }


}
