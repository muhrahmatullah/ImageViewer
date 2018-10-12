package com.rahmat.app.imgevwer.features.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.rahmat.app.imgevwer.R
import com.rahmat.app.imgevwer.data.preference.PreferenceHelper
import com.rahmat.app.imgevwer.features.base.BaseActivity
import com.rahmat.app.imgevwer.features.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject
import android.util.Patterns



class LoginActivity : BaseActivity<LoginPresenter, LoginContract.View>(), LoginContract.View {

    lateinit var email: String
    lateinit var password: String

    override fun toMainActivity() {
        startActivity<MainActivity>()
        finish()
    }

    @Inject
    lateinit var prefHelper: PreferenceHelper

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter(prefHelper)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mPresenter.isLogedIn(prefHelper.isLoggedIn())
    }

    fun login(view: View){
        hideKeyboard()
        if(validateForm()){
            mPresenter.storeUser(email, password)
        }
    }

    private fun validateForm(): Boolean{
        var proceed = true
        email =  edEmailLogin.text.toString()
        password = edPassowrdLogin.text.toString()

        if(!isEmailValid(email)){
            edEmailLogin.error = "Email is not valid"
            proceed = false
        }
        else if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
            edPassowrdLogin.error = "This field is required"
            edEmailLogin.error = "This field is required"
            proceed = false
        }
        else if (TextUtils.isEmpty(email)){
            edEmailLogin.error = "This field is required"
            proceed = false
        }else if(TextUtils.isEmpty(password)){
            edPassowrdLogin.error = "This field is required"
            proceed = false
        }
        return proceed
    }

    private fun isEmailValid(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
