package jp.techacademy.azuma.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),FragmentCallback  {

    private val viewPagerAdapter by lazy { ViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewPager2の初期化
        viewPager2.apply {
            adapter = viewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL //スワイプの向き横（ORIENTATION_VERTICAL指定なら縦スワイプで可能）
            offscreenPageLimit = viewPagerAdapter.itemCount //ViewPager2で保持する画面数
        }

        //tablayoutの初期化
        //tablayoutとViewPager2を紐づける
        //TabLayoutのTextを指定する
        TabLayoutMediator(tabLayout,viewPager2) { tab, position ->
            tab.setText(viewPagerAdapter.titleIds[position])
        }.attach()

        }




    companion object {
        private const val VIEW_PAGER_POSITION_API = 0
        private const val VIEW_PAGER_POSITION_FAVORITE = 1
    }

    override fun onAddFavorite(shop: Shop) {
        TODO("Not yet implemented")
    }

    override fun onDeleteFavorite(id: String) {
        TODO("Not yet implemented")
    }


}