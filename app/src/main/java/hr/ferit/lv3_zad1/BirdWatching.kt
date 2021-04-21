package hr.ferit.lv3_zad1

import android.app.Application
import android.content.Context

class BirdWatching: Application() {

    companion object {
        lateinit var ApplicationContext: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}