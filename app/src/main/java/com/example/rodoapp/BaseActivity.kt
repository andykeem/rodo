package com.example.rodoapp

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.actionbar_custom.*
import kotlinx.android.synthetic.main.bottom_nav.*
import kotlinx.android.synthetic.main.bottom_nav_coordinator.*

open class BaseActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    @SuppressLint("WrongConstant")
    fun updateActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            title = getString(R.string.lable_vehicle_type)
            setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
            setCustomView(R.layout.actionbar_custom)
        }

        abBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                launchHomeScreen()
                return true
            }
        }
        return false
    }

    private fun launchHomeScreen() {
        with (Intent(this, MainActivity::class.java)) {
            startActivity(this)
        }
    }
}