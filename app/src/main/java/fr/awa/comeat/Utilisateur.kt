package fr.awa.comeat

data class Utilisateur(
    val id: Int,
    val nom: String,
    val prenom: String,
    val email: String,
    val mdp: String
)