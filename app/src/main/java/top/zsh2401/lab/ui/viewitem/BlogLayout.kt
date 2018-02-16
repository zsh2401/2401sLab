package top.zsh2401.lab.ui.viewitem

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.widget.SwipeRefreshLayout
import android.text.BoringLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import top.zsh2401.lab.*
import top.zsh2401.lab.ui.activities.IMainActivityApi
import top.zsh2401.lab.ui.custom.ObservableWebView
import top.zsh2401.lab.util.BLOG_HOST
import top.zsh2401.lab.util.hostIs

/**
 * Created by zsh24 on 02/16/2018.
 */
class BlogLayout(context: Context,private val api: IMainActivityApi?=null):
        LinearLayout(context),ObservableWebView.OnScrollListener {
    override fun onScroll(dx: Int, dy: Int) {
        Log.d("Blog View","dx:$dx dy:$dy")
        if(dy>30){
            api?.showBottomNavigation()
        }else if(dy<-10){
            api?.hideBottomNavigation()
        }
    }
    private val swipeLayout:SwipeRefreshLayout
    private val mWebView:ObservableWebView
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
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return if(url!!.hostIs(BLOG_HOST)){
                    view!!.loadUrl(url)
                    true
                }else{
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    context.startActivity(intent)
                    true
                }
            }
        }
        mWebView.onScrollListener = this
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