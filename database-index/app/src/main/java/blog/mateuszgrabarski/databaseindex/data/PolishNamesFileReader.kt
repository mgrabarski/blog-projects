package blog.mateuszgrabarski.databaseindex.data

import android.content.res.AssetManager

private const val NAMES_FILE = "polish_names.txt"

class PolishNamesFileReader(
    private val assets: AssetManager
) {

    fun readNames(): List<String> {
        val lines = assets.open(NAMES_FILE).readText()
        return lines.map { it.split(",")[0] }
    }
}