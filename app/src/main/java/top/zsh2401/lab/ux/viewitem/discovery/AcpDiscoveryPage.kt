package top.zsh2401.lab.ux.viewitem.discovery

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import top.zsh2401.lab.R
import top.zsh2401.lab.ux.activities.IMainActivityApi

/**
 * Created by zsh24 on 02/18/2018.
 */
class AcpDiscoveryPage(context: Context,private val api: IMainActivityApi?=null):LinearLayout(context) {
    init {
        LayoutInflater.from(context).inflate(R.layout.page_discovery_acp,this)
    }
}