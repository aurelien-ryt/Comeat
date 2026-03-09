package fr.awa.comeat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import fr.awa.comeat.Modele.findUtilisateur

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val saisieEmail : TextView = findViewById( R.id.email)
        val saisieMdp : TextView = findViewById( R.id.mdp)

        val boutonConnecter : Button = findViewById( R.id.connecter)
        boutonConnecter.setOnClickListener {
            val email : String = saisieEmail.text.toString()
            val mdp : String = saisieMdp.text.toString()

            Log.d( "ACT_CONN" , "Connexion : $email/$mdp" )

            if( findUtilisateur) {
                setContentView(R.layout.activity_menu_repas)
            }
            else

        }
        val boutonAnnuler : Button = findViewById( R.id.annuler )

        boutonAnnuler.setOnClickListener {
            saisieEmail.setText( "" )
            saisieMdp.setText( "" )
            Log.d( "ACT_CONN" , "Annulation" )

        }
    }
}