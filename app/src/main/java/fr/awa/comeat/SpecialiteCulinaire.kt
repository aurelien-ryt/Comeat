package fr.awa.comeat

data class SpecialiteCulinaire(
    val id: Int,
    val libelle: String
){
    override fun toString(): String {
        return libelle
    }
}