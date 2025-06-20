package com.frontend.app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import android.os.Handler
import android.os.Looper
import android.content.Intent
import android.view.View
import android.view.ViewTreeObserver
//import com.frontend.app.pages.DisconnectActivity
//import com.frontend.app.pages.LoginActivity
import com.frontend.app.pages.MainAppActivity

class MainActivity : AppCompatActivity() {

    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val rootView = findViewById<View>(android.R.id.content)
        rootView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                rootView.viewTreeObserver.removeOnPreDrawListener(this)


                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this@MainActivity, MainAppActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 2500)

                return true
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun loadCustomAnimation(fileName: String) {
        val assetPath = "lottie/$fileName.json"
        lottieAnimationView.setAnimation(assetPath)
        lottieAnimationView.playAnimation()
    }
}