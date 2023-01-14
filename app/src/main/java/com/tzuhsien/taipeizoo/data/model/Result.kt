package com.tzuhsien.taipeizoo.data.model

data class Result(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Area>,
    val sort: String
)