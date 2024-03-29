package io.github.luteoos.booker.session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import io.github.luteoos.booker.view.activity.LogInActivity
import io.github.luteoos.booker.view.activity.MainScreenActivity
import java.util.*

object Session {

    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
    }


    val userUUDString: String?
        get() = preferences.getString(USER_UUID, "")
    var userUUID: UUID
        get() {
            val userUUID = preferences.getString(USER_UUID, "")
            return UUID.fromString(userUUID)
        }
        set(value) {
            preferences.edit().putString(USER_UUID, value.toString()).apply()
        }

    var username: String?
        get() = preferences.getString(USER_NAME, "")
        set(value) {
            preferences.edit().putString(USER_NAME, value).apply()
        }

    var avatar: String?
        get() = preferences.getString(USER_AVATAR, "")
        set(value) {
            preferences.edit().putString(USER_AVATAR, value).apply()
        }

    fun logout(context: Context) {
        preferences.edit().clear().apply()
        val intent = Intent(context, LogInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    private val USER_UUID = "USER_UUID"
    private val USER_NAME = "USER_NAME"
    private val USER_AVATAR = "USER_AVATAR"
}