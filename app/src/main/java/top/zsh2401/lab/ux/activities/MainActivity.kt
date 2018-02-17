package top.zsh2401.lab.ux.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.View
import top.zsh2401.lab.R
import top.zsh2401.lab.ux.adapter.UniversalViewAdapter
import top.zsh2401.lab.ux.viewitem.AboutLayout
import top.zsh2401.lab.ux.viewitem.BlogLayout
import top.zsh2401.lab.ux.viewitem.DiscoveryLayout

class MainActivity : AppCompatActivity(),IMainActivityApi {
    override fun showBottomNavigation() {
        mBtmNav.animate()?.translationY(0.toFloat())?.duration  = 50
    }

    override fun hideBottomNavigation() {
        mBtmNav.animate()?.translationY(mBtmNav.height.toFloat())?.duration  = 50
    }

    override fun navigationIsShown(): Boolean {
        return mBtmNav.y < mBtmNav.height
    }

    override fun getBottomNavigation(): BottomNavigationView {
        return mBtmNav
    }

    private lateinit var mBtmNav:BottomNavigationView
    private lateinit var mViewPager:ViewPager
    private lateinit var views:Array<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private lateinit var blogLayout:BlogLayout
    private fun init(){
        initViewObj()
        initViewPager()
    }
    private fun initViewObj(){
        mViewPager = findViewById(R.id.view_pager_main)
        mBtmNav = findViewById(R.id.btm_nav_main)
    }
    private fun initViewPager(){
        mViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                when(position){
                    0->mBtmNav.selectedItemId = R.id.btm_nav_blog
                    1->mBtmNav.selectedItemId = R.id.btm_nav_discovery
                    2->mBtmNav.selectedItemId = R.id.btm_nav_about
                }
                if(!navigationIsShown()){
                    showBottomNavigation()
                }
            }
        })
        mBtmNav.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.btm_nav_blog->{mViewPager.setCurrentItem(0,false);}
                R.id.btm_nav_discovery->{mViewPager.setCurrentItem(1,false);}
                R.id.btm_nav_about->{mViewPager.setCurrentItem(2,false);}
                else->false
            }
            true
        }
        blogLayout = BlogLayout(this,this)
        views = arrayOf(
                blogLayout,
                DiscoveryLayout(this,this),
                AboutLayout(this,this))
        mViewPager.adapter = UniversalViewAdapter(views)
    }
    override fun onBackPressed() {
        if(mViewPager.currentItem != 0){
            super.onBackPressed()
            return
        }
        if(!blogLayout.tryGoBack()) {
            super.onBackPressed()
            return
        }
    }
}
