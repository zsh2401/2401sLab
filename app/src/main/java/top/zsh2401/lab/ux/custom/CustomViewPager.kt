package top.zsh2401.lab.ux.custom

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by zsh24 on 02/16/2018.
 */
class CustomViewPager(context: Context,attr:AttributeSet):ViewPager(context,attr) {
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}