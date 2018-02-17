package top.zsh2401.lab.ux.viewitem

import android.content.Context
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_discovery_layout.view.*
import top.zsh2401.lab.R
import top.zsh2401.lab.ux.activities.IMainActivityApi
import top.zsh2401.lab.ux.adapter.UniversalViewAdapter
import top.zsh2401.lab.ux.custom.IScrollListener
import top.zsh2401.lab.ux.viewitem.discovery.AcpDiscoveryPage
import top.zsh2401.lab.ux.viewitem.discovery.NormalDiscoveryPage

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
        initViewPager()
    }
    private fun initViewPager(){
        val pages:Array<View> = arrayOf(
                NormalDiscoveryPage(context,api),
                AcpDiscoveryPage(context,api))
        view_pager_discovery.adapter = UniversalViewAdapter(pages)
        tab_discovery.setupWithViewPager(view_pager_discovery)
        tab_discovery.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab?.position == 1){
                    api?.showBottomNavigation()
                    app_bar_discovery.setExpanded(true,true)
                }

            }
        })
    }
}