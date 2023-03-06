package com.example.tallersemana7.data.preferences

import android.content.SharedPreferences
import io.reactivex.rxjava3.core.Completable

class SharedPrefsDataSource(
    private val sharedPreferences: SharedPreferences
) {

    fun findManager(): Boolean = !sharedPreferences.getString(MANAGER, null).isNullOrEmpty()

    fun registerManager(userName: String): Completable {
        return Completable.fromAction {
            sharedPreferences.edit().apply {
                putString(MANAGER, userName)
                apply()
            }
        }
    }

    fun logoutManager(userName: String) {
        sharedPreferences.edit().apply {
            clear().apply()
        }
    }

    companion object {
        private const val MANAGER = "manager"
    }
}