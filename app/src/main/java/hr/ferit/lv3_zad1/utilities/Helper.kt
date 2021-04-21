package hr.ferit.lv3_zad1.utilities

import hr.ferit.lv3_zad1.R

fun getColorResource(color: String): Int{
    return when(color){
        "grey" -> R.color.grey
        "blue" -> R.color.blue
        "red" -> R.color.red
        "green" -> R.color.green
        else -> R.color.white
    }
}