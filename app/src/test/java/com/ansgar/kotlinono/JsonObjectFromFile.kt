package com.ansgar.kotlinono

import java.io.File
import java.io.FileNotFoundException
import java.util.*

/**
 * Utility class used for creating JSONObjects from local mock data files
 */
object JsonObjectFromFile {

    /**
     * Reads a local file and converts it into a JSONObject.

     * @param filePath The relative path from the test folder, e.g. ("res/raw/testData")
     * *
     * @return A JSONObject corresponding to the JSON string in the file.
     * *
     * @throws RuntimeException if the file path is invalid or the file contains invalid JSON. Test methods should not attempt to handle this
     * *             exception, because it indicates that something is wrong with the test data.
     */
    fun readStringFromFilePath(filePath: String): String? {
        var data: String? = null
        try {
            val file = if (File(filePath).exists()) File(filePath) else File("./src/test/$filePath")
            data = file.bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            // do nothing
        }
        return data
    }
}
