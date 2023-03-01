package com.example.myapplication.core.model

data class InputNumber(
    val first: Int,
    val second: Int,
    val third: Int,
    val fourth: Int,
    val fifth: Int
) {
    fun toList() : List<Int> {
        return listOf(
            first,
            second,
            third,
            fourth,
            fifth
        )
    }
}