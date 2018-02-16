package top.zsh2401.lab.ui.viewitem

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import top.zsh2401.lab.*
import top.zsh2401.lab.ui.activities.IMainActivityApi

/**
 * Created by zsh24 on 02/16/2018.
 */
class DiscoveryLayout(context:Context,private val api: IMainActivityApi?=null):LinearLayout(context) {
    init {
        LayoutInflater.from(context).inflate(R.layout.item_discovery_layout,this)
    }
}