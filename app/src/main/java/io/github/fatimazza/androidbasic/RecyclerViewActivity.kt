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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setActionBarTitle(title)

        rvHeroes = findViewById(R.id.rv_hero)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHero())
        showRecyclerList()
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

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHer(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvHeroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback {
            override fun onItemClick(data: Hero) {
                showSelectedHer(data)
            }
        })
    }

    private fun showRecyclerCardview() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardHeroAdapter = CardViewAdapter(list)
        rvHeroes.adapter = cardHeroAdapter
    }

    private fun showSelectedHer(hero: Hero) {
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
                setActionBarTitle(title)
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                setActionBarTitle(title)
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                setActionBarTitle(title)
                showRecyclerCardview()
            }
        }
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}
