package com.example.rodrigotaboadaexamen

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class SplashScreem: AppCompatActivity() {
    var PERMISO=1
    var ubicacion=ActivityCompat.checkSelfPermission(this@SplashScreem, android.Manifest.permission.ACCESS_FINE_LOCATION)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screem)
        
        supportActionBar?.hide();
        solicitarPermiso()

        Handler().postDelayed({
            val intent = Intent(this@SplashScreem, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000L )
    }
    fun solicitarPermiso(){
        var ubicacion=ActivityCompat.checkSelfPermission(this@SplashScreem, android.Manifest.permission.ACCESS_FINE_LOCATION)
        if(ubicacion!=PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), PERMISO)
        }
    }
}