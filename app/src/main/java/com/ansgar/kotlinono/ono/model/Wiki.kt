package com.ansgar.kotlinono.ono.model

object Wiki {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}