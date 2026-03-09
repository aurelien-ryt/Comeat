package fr.awa.comeat

import android.R.attr.duration
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
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

            if(findUtilisateur( email , mdp ) != null) {
                Log.d( "ACT_CONN" , "Connexion réussie" )

                Toast.makeText(
                    this,
                    "Connexion réussie !",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent( this , MenuRepasActivity::class.java)
                startActivity( intent)
            }

            else{
                Toast.makeText(
                    this,
                    "Erreur de connexion !",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d( "ACT_CONN" , "Erreur de connexion" )

            }

        }
        val boutonAnnuler : Button = findViewById( R.id.annuler )

        boutonAnnuler.setOnClickListener {
            saisieEmail.setText( "" )
            saisieMdp.setText( "" )
            Log.d( "ACT_CONN" , "Annulation" )

        }
    }
}