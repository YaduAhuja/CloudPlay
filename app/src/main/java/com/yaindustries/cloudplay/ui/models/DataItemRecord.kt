package com.yaindustries.cloudplay.ui.models

data class DataItemRecord(
    val imgUrl : String,
    val itemName : String,
    val author : String,
    val isPlaying : Boolean = false,
    val isFavorite : Boolean = false
)
