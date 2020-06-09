package com.udacity.notepad

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.udacity.notepad.crud.CreateActivity
import com.udacity.notepad.recycler.NotesAdapter
import com.udacity.notepad.util.SpaceItemDecoration

class MainActivity : AppCompatActivity() {

    @Override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                startActivity(CreateActivity.get(this@MainActivity))
            }
        })
        recycler.setLayoutManager(LinearLayoutManager(this))
        recycler.addItemDecoration(SpaceItemDecoration(this, R.dimen.margin_small))
        recycler.setAdapter(NotesAdapter(this))
    }

    @Override
    protected fun onResume() {
        super.onResume()
        refresh()
    }

    @Override
    fun onDestroy() {
        super.onDestroy()
        recycler.setAdapter(null)
    }

    @Override
    fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    @Override
    fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.getItemId()) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun refresh() {
        (recycler.getAdapter() as NotesAdapter).refresh()
    }
}