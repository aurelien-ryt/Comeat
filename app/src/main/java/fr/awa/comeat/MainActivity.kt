package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val bouton : Button = findViewById( R.id.goToMenuRepasActivity)
        bouton.setOnClickListener {
        val intent = Intent( this , MenuRepasActivity::class.java)
        startActivity( intent)
        }
    }
}