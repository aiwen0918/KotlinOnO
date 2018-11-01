package com.ansgar.kotlinono

import com.ansgar.kotlinono.ono.model.Wiki
import com.google.gson.GsonBuilder
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        // Assign
        val response = JsonObjectFromFile.readStringFromFilePath("res/raw/wiki.json")

        var gson = GsonBuilder().create()
        var wiki = gson.fromJson(response, Wiki.Result::class.java)
        assertEquals(23747, wiki.query.searchinfo.totalhits)
    }
}
