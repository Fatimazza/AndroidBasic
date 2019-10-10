package io.github.fatimazza.androidbasic

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import io.github.fatimazza.androidbasic.fragment.HomeFragment

class ActionBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options_actionbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuFragment -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, HomeFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.menuActivity -> {
                val intentActivity = Intent(this, IntentMoveActivity::class.java)
                startActivity(intentActivity)
                return true
            }
            else -> return false
        }
    }
}
