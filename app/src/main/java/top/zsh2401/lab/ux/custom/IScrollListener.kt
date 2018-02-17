package top.zsh2401.lab.ux.custom

import android.view.View

/**
 * Created by zsh24 on 02/16/2018.
 */
interface IScrollListener {
    fun onScroll(view: View,dx:Int,dy:Int)
}