package com.ansgar.kotlinono

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ansgar.kotlinono.ono.ui.OnOFragment

class OnOActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ono_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, OnOFragment.newInstance())
                .commitNow()
        }
    }

}
