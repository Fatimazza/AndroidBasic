package io.github.fatimazza.androidbasic

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCalculateVolume: Button
    private lateinit var btnIntent: Button
    private lateinit var btnViews: Button
    private lateinit var btnFragment: Button
    private lateinit var btnRecyclerView: Button
    private lateinit var btnListView: Button
    private lateinit var btnActionBar: Button
    private lateinit var btnNavDrawer: Button
    private lateinit var btnBottomNav: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnCalculateVolume = findViewById(R.id.btnCalculateVolume)
        btnIntent = findViewById(R.id.btnIntent)
        btnViews = findViewById(R.id.btnViews)
        btnRecyclerView = findViewById(R.id.btnRecyclerView)
        btnFragment = findViewById(R.id.btnFragment)
        btnListView = findViewById(R.id.btnListView)
        btnActionBar = findViewById(R.id.btnActionBar)
        btnNavDrawer = findViewById(R.id.btnNavDrawer)
        btnBottomNav = findViewById(R.id.btnBottomNav)

        setClickListener()
    }

    private fun setClickListener() {
        btnCalculateVolume.setOnClickListener(this)
        btnIntent.setOnClickListener(this)
        btnViews.setOnClickListener(this)
        btnRecyclerView.setOnClickListener(this)
        btnFragment.setOnClickListener(this)
        btnListView.setOnClickListener(this)
        btnActionBar.setOnClickListener(this)
        btnNavDrawer.setOnClickListener(this)
        btnBottomNav.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnCalculateVolume -> {
                val calculationIntent = Intent(this, MainActivity::class.java)
                startActivity(calculationIntent)
            }

            R.id.btnIntent -> {
                val demoIntent = Intent(this, IntentActivity::class.java)
                startActivity(demoIntent)
            }

            R.id.btnViews -> {
                val viewsIntent = Intent(this, ViewsActivity::class.java)
                startActivity(viewsIntent)
            }

            R.id.btnRecyclerView -> {
                val recyclerviewIntent = Intent(this, RecyclerViewActivity::class.java)
                startActivity(recyclerviewIntent)
            }

            R.id.btnFragment -> {
                val fragmentIntent = Intent(this, FragmentActivity::class.java)
                startActivity(fragmentIntent)
            }

            R.id.btnListView -> {
                val listviewIntent = Intent(this, ListViewActivity::class.java)
                startActivity(listviewIntent)
            }

            R.id.btnActionBar -> {
                val actionbarIntent = Intent(this, ActionBarActivity::class.java)
                startActivity(actionbarIntent)
            }

            R.id.btnNavDrawer -> {
                val navDrawerIntent = Intent(this, NavigationDrawerActivity::class.java)
                startActivity(navDrawerIntent)
            }

            R.id.btnBottomNav -> {
                val bottomNavIntent = Intent(this, BottomNavigationActivity::class.java)
                startActivity(bottomNavIntent)
            }
        }
    }
}
