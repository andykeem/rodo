package com.example.rodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_nav.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearchByType.setOnClickListener {
            launchListScreen()
        }

        val menuItem = nav_view.menu.findItem(R.id.navigation_home)
        menuItem.setChecked(true)
    }

    fun launchListScreen() {
        with (Intent(this, ListActivity::class.java)) {
            startActivity(this)
        }
    }
}