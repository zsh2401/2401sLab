package top.zsh2401.lab.ux.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import top.zsh2401.lab.R
import top.zsh2401.lab.ux.adapter.UniversalViewAdapter
import top.zsh2401.lab.ux.viewitem.AboutLayout
import top.zsh2401.lab.ux.viewitem.BlogLayout
import top.zsh2401.lab.ux.viewitem.DiscoveryLayout

class MainActivity : AppCompatActivity(),IMainActivityApi {
    override fun showBottomNavigation() {
        btm_nav_main.animate()?.translationY(0.toFloat())?.duration  = 50
    }

    override fun hideBottomNavigation() {
        btm_nav_main.animate()?.translationY(btm_nav_main.height.toFloat())?.duration  = 50
    }

    override fun navigationIsShown(): Boolean {
        return btm_nav_main.y < btm_nav_main.height
    }

    override fun getBottomNavigation(): BottomNavigationView {
        return btm_nav_main
    }

    private lateinit var views:Array<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private lateinit var blogLayout:BlogLayout
    private fun init(){
        initViewPager()
    }
    private fun initViewPager(){
        view_pager_main.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                when(position){
                    0->btm_nav_main.selectedItemId = R.id.btm_nav_blog
                    1->btm_nav_main.selectedItemId = R.id.btm_nav_discovery
                    2->btm_nav_main.selectedItemId = R.id.btm_nav_about
                }
                if(!navigationIsShown()){
                    showBottomNavigation()
                }
            }
        })
        btm_nav_main.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.btm_nav_blog->{view_pager_main.setCurrentItem(0,false);}
                R.id.btm_nav_discovery->{view_pager_main.setCurrentItem(1,false);}
                R.id.btm_nav_about->{view_pager_main.setCurrentItem(2,false);}
                else->false
            }
            true
        }
        blogLayout = BlogLayout(this,this)
        views = arrayOf(
                blogLayout,
                DiscoveryLayout(this,this),
                AboutLayout(this,this))
        view_pager_main.adapter = UniversalViewAdapter(views)
    }
    override fun onBackPressed() {
        if(view_pager_main.currentItem != 0){
            super.onBackPressed()
            return
        }
        if(!blogLayout.tryGoBack()) {
            super.onBackPressed()
            return
        }
    }
}
