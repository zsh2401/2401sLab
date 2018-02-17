package top.zsh2401.lab.ux.activities

import android.support.design.widget.BottomNavigationView

/**
 * Created by zsh24 on 02/16/2018.
 */
interface IMainActivityApi {
    fun getBottomNavigation():BottomNavigationView
    fun showBottomNavigation()
    fun hideBottomNavigation()
    fun navigationIsShown():Boolean
}