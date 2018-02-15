package top.zsh2401.lab

import android.app.Application

/**
 * Created by zsh24 on 02/16/2018.
 */
class App:Application() {
    companion object {
        val current:App get() = _current
        private lateinit var _current:App
    }
    override fun onCreate() {
        super.onCreate()
        _current = this
    }
}