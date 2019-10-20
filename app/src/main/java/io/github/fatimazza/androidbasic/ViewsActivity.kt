package io.github.fatimazza.androidbasic

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class ViewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Google Pixel"
        }

    }
}
