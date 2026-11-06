package com.example.smartvolt

import android.app.Application
import androidx.preference.PreferenceManager
import org.osmdroid.config.Configuration

class SmartVoltApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val config = Configuration.getInstance()
        config.load(this, PreferenceManager.getDefaultSharedPreferences(this))
        // Identifica la app y ofrece un contacto del proyecto al proveedor de teselas.
        config.userAgentValue =
            "SmartVolt/1.0 (https://github.com/gatogalleta123/Smart-volt; Android)"
        config.osmdroidBasePath = cacheDir        // caché de tiles
        config.osmdroidTileCache = cacheDir.resolve("tiles")

    }
}