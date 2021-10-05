package blog.mateuszgrabarski.databaseindex.data

import java.io.InputStream
import kotlin.text.Charsets.UTF_8

fun InputStream.readText(): List<String> {
    return this.bufferedReader(charset = UTF_8).readLines()
}