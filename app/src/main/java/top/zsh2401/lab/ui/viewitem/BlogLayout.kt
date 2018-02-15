package top.zsh2401.lab.ui.viewitem

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import top.zsh2401.lab.*

/**
 * Created by zsh24 on 02/16/2018.
 */
class BlogLayout(context: Context):LinearLayout(context) {
    private val swipeLayout:SwipeRefreshLayout
    private val mWebView:WebView
    init {
        LayoutInflater.from(context).inflate(R.layout.item_blog_layout,this)
        swipeLayout = findViewById(R.id.swipe_refresh)
        mWebView = findViewById(R.id.web_view_blog)
        swipeLayout.setOnRefreshListener {
            mWebView.reload()
        }
        mWebView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = object:WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipeLayout.isRefreshing = false
            }
        }
        mWebView.loadUrl("http://zsh2401.top")
    }
    fun tryGoBack():Boolean{
        return if(mWebView.canGoBack()){
            mWebView.goBack()
            true
        }else{
            false
        }
    }
}