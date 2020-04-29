package com.example.meditations

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver

class App : Application() {

    companion object {
        private lateinit var db: Database
    }
    override fun onCreate() {
        super.onCreate()
        db = Database(
            AndroidSqliteDriver(
                Database.Schema,
                applicationContext,
                "meditations.db"
        ))
    }
}