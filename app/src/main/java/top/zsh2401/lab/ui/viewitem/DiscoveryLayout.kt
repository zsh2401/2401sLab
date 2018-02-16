package top.zsh2401.lab.ui.viewitem

import android.content.Context
import android.support.v4.widget.NestedScrollView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import top.zsh2401.lab.*
import top.zsh2401.lab.ui.activities.IMainActivityApi
import top.zsh2401.lab.ui.custom.IScrollListener
import top.zsh2401.lab.ui.custom.ObservableNestedScrollView
import top.zsh2401.lab.ui.custom.ObservableWebView

/**
 * Created by zsh24 on 02/16/2018.
 */
class DiscoveryLayout(context:Context,private val api: IMainActivityApi?=null):
        LinearLayout(context), IScrollListener {
    override fun onScroll(view: View, dx: Int, dy: Int) {
        if(dy>30){
            api?.hideBottomNavigation()
        }else if(dy<-10){
            api?.showBottomNavigation()
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.item_discovery_layout,this)
        findViewById<ObservableNestedScrollView>(R.id.nsv_discovery).onNestedScrollListener = this
    }
}