package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private val listView: ListView
        get() = lv_listview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        loadListArrayAdapter()
    }

    private fun loadListArrayAdapter() {
        val dataName = arrayOf(
            "Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin",
            "Patimura", "R A Kartini", "Sukarno"
        )

        val adapter = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, dataName
        )
        listView.adapter = adapter
    }
}
