package top.zsh2401.lab.ux.viewitem

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_blog_layout.view.*
import top.zsh2401.lab.R
import top.zsh2401.lab.util.BLOG_HOST
import top.zsh2401.lab.util.hostIs
import top.zsh2401.lab.ux.activities.IMainActivityApi
import top.zsh2401.lab.ux.custom.IScrollListener

/**
 * Created by zsh24 on 02/16/2018.
 */
class BlogLayout(context: Context,private val api: IMainActivityApi?=null):
        LinearLayout(context),IScrollListener {
    override fun onScroll(view:View,dx: Int, dy: Int) {
        if(dy>30){
            api?.hideBottomNavigation()
        }else if(dy<-10){
            api?.showBottomNavigation()
        }
    }
    init {
        LayoutInflater.from(context).inflate(R.layout.item_blog_layout,this)
        swipe_refresh.setOnRefreshListener {
            web_view_blog.reload()
        }

        web_view_blog.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        web_view_blog.settings.javaScriptEnabled = true
        web_view_blog.webViewClient = object:WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipe_refresh.isRefreshing = false
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
        web_view_blog.onScrollListener = this
        web_view_blog.loadUrl("http://zsh2401.top")
    }
    fun tryGoBack():Boolean{
        return if(web_view_blog.canGoBack()){
            web_view_blog.goBack()
            true
        }else{
            false
        }
    }
}