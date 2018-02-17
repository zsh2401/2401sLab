package top.zsh2401.lab.ux.custom

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

/**
 * Created by zsh24 on 02/16/2018.
 */
class ObservableWebView(context: Context,attr:AttributeSet ):WebView(context,attr) {
    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        onScrollListener?.onScroll(this,l-oldl,t-oldt)
        super.onScrollChanged(l, t, oldl, oldt)
    }
    lateinit var onScrollListener:IScrollListener
}