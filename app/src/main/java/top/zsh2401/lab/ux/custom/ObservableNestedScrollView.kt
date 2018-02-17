package top.zsh2401.lab.ux.custom

import android.content.Context
import android.support.v4.widget.NestedScrollView
import android.util.AttributeSet

/**
 * Created by zsh24 on 02/16/2018.
 */
class ObservableNestedScrollView(context: Context, attr:AttributeSet):
        NestedScrollView(context,attr) {
    lateinit var onNestedScrollListener:IScrollListener
    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        onNestedScrollListener?.onScroll(this,l - oldl,t-oldt)
    }
}