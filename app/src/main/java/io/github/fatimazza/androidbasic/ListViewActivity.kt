package io.github.fatimazza.androidbasic

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import io.github.fatimazza.androidbasic.adapter.ListViewHeroAdapter
import io.github.fatimazza.androidbasic.model.Hero
import io.github.fatimazza.androidbasic.model.HeroesData
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private val listView: ListView
        get() = lv_listview

    private var list: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        //loadListArrayAdapter()
        loadListBaseAdapter(this)
        setItemClickListener(listView)
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

    private fun loadListBaseAdapter(context: Context) {
        list.addAll(HeroesData.listData)

        val baseAdapter = ListViewHeroAdapter(context, list)
        listView.adapter = baseAdapter
    }

    private fun setItemClickListener(listView: ListView) {
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, index, _ ->
                Toast.makeText(
                    this@ListViewActivity, list.get(index).name,
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}
