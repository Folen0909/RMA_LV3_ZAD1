package hr.ferit.lv3_zad1.persistence

import android.content.Context
import hr.ferit.lv3_zad1.BirdWatching

class PreferenceManager {

    companion object {
        const val PREFS_FILE = "MyPreferences"
        const val PREFS_KEY_COUNTER = "counter"
        const val PREFS_KEY_COLOR = "color"
    }

    fun saveCounter(counter: String) {
        val sharedPreferences = BirdWatching.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_COUNTER, counter)
        editor.apply()
    }
    fun retrieveCounter(): String {
        val sharedPreferences = BirdWatching.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(PREFS_KEY_COUNTER, "0").toString()
    }

    fun saveColor(color: String) {
        val sharedPreferences = BirdWatching.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_COLOR, color)
        editor.apply()
    }
    fun retrieveColor(): String {
        val sharedPreferences = BirdWatching.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(PREFS_KEY_COLOR, "white").toString()
    }

}