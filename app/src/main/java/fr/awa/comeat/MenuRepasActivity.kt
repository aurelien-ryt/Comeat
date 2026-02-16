package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MenuRepasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_repas)
        val bouton : Button = findViewById( R.id.goToRepasActivity)
        bouton.setOnClickListener {
            val intent = Intent( this , RepasActivity::class.java)
            startActivity( intent)
        }
        setContentView(R.layout.activity_menu_repas)
        val bouton2 : Button = findViewById( R.id.goToRechercheRepasActivity)
        bouton2.setOnClickListener {
            val intent = Intent( this , RechercheRepasActivity::class.java)
            startActivity( intent)
        }
    }
}