package com.rahmat.app.imgevwer.features.main

import android.os.Bundle
import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.features.base.BaseActivity
import com.rahmat.app.imgevwer.features.image.ImageFragment
import com.rahmat.app.imgevwer.features.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_nav_view.*

class MainActivity : BaseActivity<MainPresenter, MainContract.View>(), MainContract.View {

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun loadHome(savedInstanceState: Bundle?) {
        if(savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, ImageFragment(), ImageFragment::class.java.simpleName )
                    .commit()
        }
    }

    override fun loadProfile(savedInstanceState: Bundle?) {
        if(savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, ProfileFragment(), ProfileFragment::class.java.simpleName )
                    .commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarMain)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> loadHome(savedInstanceState)
                R.id.profile -> loadProfile(savedInstanceState)
                else -> loadHome(savedInstanceState)
            }
            true
        }

        bottom_navigation.selectedItemId = R.id.home

    }
}
