package fr.awa.comeat

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.view.View
import android.widget.Spinner
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RechercheRepasActivity : AppCompatActivity() {

    private var libelleSpecialite: String = ""
    private var dateRepas: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        // Ce qu'on affiche a l'arrivé :
        setContentView(R.layout.activity_recherche_repas)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val spnSpecialite: Spinner = findViewById(R.id.select_specialite)
        // val specialites = listOf( "Provençal", "Marocain" , "Libanais" , "Afghan" , "Coréen" )
        val specialites = Modele.getSpecialites()


        val adaptateur = ArrayAdapter(this, android.R.layout.simple_spinner_item, specialites)

        adaptateur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spnSpecialite.adapter = adaptateur
        spnSpecialite.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                libelleSpecialite = parentView.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Rien à faire
            }
        }


        val btnDate: Button = findViewById(R.id.select_date)
        val tvDate: TextView = findViewById(R.id.aff_date)

        val btnValider: Button = findViewById(R.id.ValiderAndGoToListeRepasActivity)
        btnValider.setEnabled(false)

        btnDate.setOnClickListener {
            val dateCourante = LocalDate.now()
            val annee = dateCourante.year
            val mois = dateCourante.monthValue - 1
            val jour = dateCourante.dayOfMonth

            val datePickerDialog = DatePickerDialog(
                this,
                { view, anneeSelect, moisSelect, jourSelect ->
                    val dateSelectionnee = LocalDate.of(
                        anneeSelect,
                        moisSelect + 1,
                        jourSelect
                    )
                    val formateur = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val dateFormatee = dateSelectionnee.format(formateur)
                    tvDate.text = dateFormatee
                    dateRepas = dateFormatee

                    if (dateRepas != "") {
                        btnValider.setEnabled(true)
                    } else {
                        btnValider.setEnabled(false)
                    }
                },
                annee, mois, jour
            )
            datePickerDialog.show()
        }


        btnValider.setOnClickListener {
            val intent = Intent(this, ListeRepasActivity::class.java)

            intent.putExtra("specialite_repas", libelleSpecialite)
            intent.putExtra("date_repas", dateRepas)

            startActivity(intent)
        }

    }
}