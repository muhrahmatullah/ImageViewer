package com.rahmat.app.imgevwer.features.detailimage

import android.os.Bundle
import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.features.base.BaseActivity

class DetailActivity : BaseActivity<DetailPresenter, DetailContract.View>(), DetailContract.View {
    override fun createPresenter(): DetailPresenter {
        return DetailPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
