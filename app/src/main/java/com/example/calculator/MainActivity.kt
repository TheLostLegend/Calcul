package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tabLayout = findViewById(R.id.tab_layout)
        var viewPager: ViewPager2 = findViewById(R.id.viewpager)

        var adapter: ViewPagerAdapter = ViewPagerAdapter(this)

        var bet1Fragment = Bet1Fragment()
        var bet2Fragment = Bet2Fragment()

        adapter.addNewFragment(bet1Fragment)
        adapter.addNewFragment(bet2Fragment)

        viewPager.adapter = adapter

        var mediator: TabLayoutMediator = TabLayoutMediator(tabLayout, viewPager
        ) { tab, position -> // Styling each tab here
            tab.text = "Tab $position"
        }
        mediator.attach()


    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        math_operation.text = savedInstanceState.getString("math_operation")
        resultText.text = savedInstanceState.getString("result_text")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("math_operation", math_operation.text.toString())
        outState.putString("result_text", resultText.text.toString())
    }

    class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

        var fragments: MutableList<Fragment> = ArrayList<Fragment>()

        fun addNewFragment(newFragment: Fragment) {
            fragments.add(newFragment)
        }

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments.get(position)
        }
    }
}