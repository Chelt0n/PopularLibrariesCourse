package com.example.coursepopularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coursepopularlibraries.ui.profile.ProfileFragment
import com.example.coursepopularlibraries.ui.users.ListOfUsersFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListOfUsersFragment()).commit()
    }

}