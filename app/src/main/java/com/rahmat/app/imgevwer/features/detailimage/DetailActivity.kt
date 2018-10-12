package com.rahmat.app.imgevwer.features.detailimage

import android.os.Bundle
import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.features.base.BaseActivity
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import kotlinx.android.synthetic.main.activity_detail.*
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout




class DetailActivity : BaseActivity<DetailPresenter, DetailContract.View>(), DetailContract.View {
    override fun displaySlider(cat: HashMap<String, Int>) {
        for (name in cat.keys) {
            val textSliderView = TextSliderView(this)
            // initialize a SliderLayout
            cat.get(name)?.let {
                textSliderView
                        .description(name)
                        .image(it)
                        .setScaleType(BaseSliderView.ScaleType.Fit)
            }
            slider.addSlider(textSliderView)
        }
        slider.setCustomAnimation(DescriptionAnimation())
        slider.setDuration(6000)
    }

    override fun createPresenter(): DetailPresenter {
        return DetailPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mPresenter.initSlider()
    }

    override fun onStop() {
        slider.stopAutoCycle()
        super.onStop()
    }
}
