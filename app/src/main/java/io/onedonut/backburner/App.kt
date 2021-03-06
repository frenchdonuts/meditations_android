package io.onedonut.backburner

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver

class App : Application() {

    companion object {
        lateinit var db: Database
            private set
    }
    override fun onCreate() {
        super.onCreate()
        db = Database(
            AndroidSqliteDriver(
                Database.Schema,
                applicationContext,
                "backburner.db"
        ))
    }
}