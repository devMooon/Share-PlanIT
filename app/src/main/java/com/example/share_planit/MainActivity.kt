package com.example.share_planit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.share_planit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //뷰 페이져를 위한 어댑터
    class MyFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        //프래그먼트 묶음
        val fragments:List<Fragment>
        init {
            fragments = listOf(Fragment1(), Fragment2(), Fragment3())
        }

        override fun getItemCount(): Int {
            //TODO("Not yet implemented")
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            //TODO("Not yet implemented")
            return fragments[position]
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        //viewPager 등록
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPager.adapter = MyFragmentAdapter(this)

        //floting button 처리
        binding.fab.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}