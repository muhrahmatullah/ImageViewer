package com.rahmat.app.imgevwer.features.base

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.Toast
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

/**
 * Created by muhrahmatullah on 12/10/18.
 */
abstract class BaseActivity<P : BasePresenter<V>, V : BaseContract.View>: AppCompatActivity(),
        BaseContract.View, HasSupportFragmentInjector {


    var isActivityInBackground: Boolean = false
        private set

    private var isActivityStopped: Boolean = false

    protected lateinit var mPresenter: P

    private var progressBar: ProgressBar? = null

    @Inject
    lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mFragmentInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        mPresenter = createPresenter()
        @Suppress("UNCHECKED_CAST")
        mPresenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        isActivityInBackground = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        isActivityInBackground = true
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        isActivityStopped = false
        super.onStart()
    }

    override fun onStop() {
        isActivityInBackground = true
        isActivityStopped = true
        super.onStop()
    }

    override fun showLoading() {
        hideLoading()
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {

    }

    override fun onError(message: String) {

    }

    protected abstract fun createPresenter(): P

    protected fun setSnackBar(view: View, message: String) {
        if(!isActivityInBackground) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}