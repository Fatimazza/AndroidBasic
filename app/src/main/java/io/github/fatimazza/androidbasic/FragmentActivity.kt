package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.fatimazza.androidbasic.fragment.HomeFragment


class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = HomeFragment()
        fragmentTransaction.add(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }
}
