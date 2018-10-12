package com.rahmat.app.imgevwer.data.preference

/**
 * Created by muhrahmatullah on 12/10/18.
 */
interface PreferenceHelper {

    fun getUserEmail() : String?

    fun setUserEmail(email:String?)

    fun getUserPassword() : String?

    fun setUserPassword(password: String)

    fun isLoggedIn(): Boolean

    fun setLoggedIn(log: Boolean)

    fun clearSharedPref()

}