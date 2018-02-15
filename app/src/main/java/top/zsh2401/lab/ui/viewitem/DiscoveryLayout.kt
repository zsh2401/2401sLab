package top.zsh2401.lab.ui.viewitem

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import top.zsh2401.lab.*

/**
 * Created by zsh24 on 02/16/2018.
 */
class DiscoveryLayout(context:Context):LinearLayout(context) {
    init {
        LayoutInflater.from(context).inflate(R.layout.item_discovery_layout,this)
    }
}