package com.tzuhsien.taipeizoo.data.model

data class ResultAnimal(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Animal>,
    val sort: String
)