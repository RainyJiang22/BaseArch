package com.base.arch.module.main


import android.os.Bundle
import androidx.activity.viewModels
import com.base.arch.R
import com.base.arch.base.BaseActivity
import com.base.arch.bean.Tab
import com.base.arch.const.TabId
import com.base.arch.databinding.ActivityMainBinding
import com.base.arch.module.home.HomeFragment
import com.base.arch.module.mine.MineFragment
import com.base.arch.module.radio.RadioFragment
import com.base.arch.widget.NavigationView
import com.base.arch.widget.TabIndicatorView
import com.gyf.immersionbar.ktx.immersionBar

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    //当前选中的Tab底栏
    private var currentTabId = HOME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
        updateTitle()
        initTabs()
    }


    //禁止左滑返回
    override fun swipeBackEnable(): Boolean {
        return false
    }


    /**
     * 状态栏导航栏初始化
     */
    private fun initSystemBar() {
        immersionBar {
            transparentStatusBar()
            statusBarDarkFont(true)
            navigationBarColor(R.color.white)
            navigationBarDarkIcon(true)
        }
    }

    /**
     * 初始化底部栏
     */
    private fun initTabs() {
        val tabs = listOf(
            Tab(
                HOME,
                getString(R.string.page_home),
                R.drawable.selector_btn_home,
                HomeFragment::class
            ),
            Tab(
                RADIO,
                getString(R.string.page_radio),
                R.drawable.selector_btn_radio,
                RadioFragment::class
            ),
            Tab(
                MINE,
                getString(R.string.page_mine),
                R.drawable.selector_btn_mine,
                MineFragment::class
            ),
        )

        viewBinding.fragmentTabHost.run {
            //调用setup方法
            setup(this@MainActivity, supportFragmentManager, viewBinding.fragmentContainer.id)
            tabs.forEach {
                val (id, title, icon, fragmentClz) = it
                val tabSpec = newTabSpec(id).apply {
                    setIndicator(TabIndicatorView(this@MainActivity).apply {
                        viewBinding.tabIcon.setImageResource(icon)
                        viewBinding.tabTitle.text = title
                    })
                }
                addTab(tabSpec, fragmentClz.java, null)
            }

            setOnTabChangedListener { tabId ->
                currentTabId = tabId
                updateTitle()
            }
        }
    }


    /**
     * 更新标题
     */
    private fun updateTitle() {
        val title = when (currentTabId) {
            HOME -> getString(R.string.page_home)
            RADIO -> getString(R.string.page_radio)
            MINE -> getString(R.string.page_mine)
            else -> ""
        }

        viewBinding.navigationBar.setParameter(
            NavigationView.ParameterBuilder()
                .setShowBack(false)
                .setShowTitle(true)
                .setTitle(title)
        )
    }


    /**
     * 设置当前选择的tab
     */
    private fun setCurrentTab(tabID: String) {
        viewBinding.fragmentTabHost.setCurrentTabByTag(tabID)
    }


    companion object {
        const val HOME = "home"
        const val RADIO = "radio"
        const val MINE = "mine"
    }
}