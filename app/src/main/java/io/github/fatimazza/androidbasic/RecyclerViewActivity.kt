package io.github.fatimazza.androidbasic

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import io.github.fatimazza.androidbasic.adapter.CardViewAdapter
import io.github.fatimazza.androidbasic.adapter.GridHeroAdapter
import io.github.fatimazza.androidbasic.adapter.ListHeroAdapter
import io.github.fatimazza.androidbasic.model.Hero

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private var list: ArrayList<Hero> = arrayListOf()

    private var title: String = "Mode List"
    private var mode: Int = 0

    companion object {
        private const val STATE_TITLE = "state_title"
        private const val STATE_LIST = "state_list"
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        rvHeroes = findViewById(R.id.rv_hero)
        rvHeroes.setHasFixedSize(true)

        if (savedInstanceState == null) {
            setActionBarTitle(title)
            mode = R.id.action_list
            list.addAll(getListHero())
            showRecyclerList()
        } else {
            title = savedInstanceState.getString(STATE_TITLE).toString()
            val stateList = savedInstanceState.getParcelableArrayList<Hero>(STATE_LIST)
            val stateMode = savedInstanceState.getInt(STATE_MODE)

            setActionBarTitle(title)
            if (stateList != null) {
                list.addAll(stateList)
            }
            setMode(stateMode)
        }
    }

    private fun getListHero(): ArrayList<Hero> {
        val heroName = resources.getStringArray(R.array.hero_name)
        val heroDesc = resources.getStringArray(R.array.hero_description)
        val heroPhoto = resources.getStringArray(R.array.hero_photo)

        val listHero = ArrayList<Hero>()
        for (position in heroName.indices) {
            val hero = Hero(
                heroName[position],
                heroDesc[position],
                heroPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_TITLE, title)
        outState.putParcelableArrayList(STATE_LIST, list)
        outState.putInt(STATE_MODE, mode)
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvHeroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback {
            override fun onItemClick(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCardview() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardHeroAdapter = CardViewAdapter(list)
        rvHeroes.adapter = cardHeroAdapter
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "You choose " + hero.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_recycler_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardview()
            }
        }
        mode = selectedMode
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}
