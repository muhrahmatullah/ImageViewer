package com.rahmat.app.imgevwer.data.preference

import android.content.Context
import android.content.SharedPreferences
import com.rahmat.app.imgevwer.di.ApplicationContext
import com.rahmat.app.imgevwer.di.PreferenceInfo
import javax.inject.Inject

/**
 * Created by muhrahmatullah on 12/10/18.
 */
class PreferenceHelperImp @Inject constructor(@ApplicationContext val context: Context,
                                              @PreferenceInfo val prefFileName: String) : PreferenceHelper{

    companion object {
        const val PREF_KEY_EMAIL = "PREF_KEY_EMAIL"
        const val PREF_KEY_PASSWORD = "PREF_KEY_RESULT"
        const val PREF_LOGGED_IN = "PREF_LOGGED_IN"
    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getUserEmail(): String? {
        return mPrefs.getString(PREF_KEY_EMAIL, "")
    }

    override fun setUserEmail(email: String?) {
        mPrefs.edit().putString(PREF_KEY_EMAIL, email).apply()
    }

    override fun getUserPassword(): String? {
        return mPrefs.getString(PREF_KEY_PASSWORD, "")
    }

    override fun setUserPassword(password: String) {
        mPrefs.edit().putString(PREF_KEY_PASSWORD, password).apply()
    }

    override fun isLoggedIn(): Boolean {
        return mPrefs.getBoolean(PREF_LOGGED_IN, false)
    }

    override fun setLoggedIn(log: Boolean) {
        mPrefs.edit().putBoolean(PREF_LOGGED_IN, log).apply()
    }

    override fun clearSharedPref() {
        mPrefs.edit()
                .clear()
                .apply()
    }
}