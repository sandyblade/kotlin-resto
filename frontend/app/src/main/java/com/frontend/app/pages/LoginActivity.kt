package com.frontend.app.pages

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.frontend.app.R
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar


class LoginActivity : AppCompatActivity() {

    private lateinit var progressDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        val imageView = findViewById<ImageView>(R.id.imageFromUrl)
        Glide.with(this)
            .load("https://5an9y4lf0n50.github.io/demo-images/demo-resto/burger.png")
            .into(imageView)

        val btnLoginClicked = findViewById<Button>(R.id.btnLogin)
        btnLoginClicked.setOnClickListener {
            showLoadingDialog()
            Handler(Looper.getMainLooper()).postDelayed({
                progressDialog.dismiss()
                Toast.makeText(this, "Finished!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainAppActivity::class.java)
                startActivity(intent)
            }, 3000)
        }

        val btnForgotClicked = findViewById<Button>(R.id.btnForgotPassword)
        btnForgotClicked.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showLoadingDialog() {
        val progressBar = ProgressBar(this)
        progressBar.isIndeterminate = true

        val builder = AlertDialog.Builder(this)
            .setTitle("Loading...")
            .setView(progressBar)
            .setCancelable(false)

        progressDialog = builder.create()
        progressDialog.show()
    }

}