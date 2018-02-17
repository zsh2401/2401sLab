package top.zsh2401.lab.ux.viewitem.discovery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.page_discovery_normal.view.*
import top.zsh2401.lab.R
import top.zsh2401.lab.ux.activities.IMainActivityApi
import top.zsh2401.lab.ux.custom.IScrollListener

/**
 * Created by zsh24 on 02/18/2018.
 */
class NormalDiscoveryPage(context:Context,private val api: IMainActivityApi?=null):LinearLayout(context), IScrollListener {
    override fun onScroll(view: View, dx: Int, dy: Int) {
        if(dy>30){
            api?.hideBottomNavigation()
        }else if(dy<-10){
            api?.showBottomNavigation()
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.page_discovery_normal,this)
        nsv_discovery_normal.onNestedScrollListener = this
    }
}