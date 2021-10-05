package blog.mateuszgrabarski.databaseindex.data.generator

import blog.mateuszgrabarski.databaseindex.data.PolishNamesFileReader
import blog.mateuszgrabarski.databaseindex.database.entities.UserEntity
import kotlin.random.Random

private const val NUMBER_OF_RECORDS = 1_000_000

class DataGenerator(
    private val namesReader: PolishNamesFileReader
) {

    fun generate(numberOfRows: Int = NUMBER_OF_RECORDS): List<UserEntity> {
        val names = namesReader.readNames()
        val data = mutableListOf<UserEntity>()
        for (i in 1..numberOfRows) {
            data.add(UserEntity(names[Random.nextInt(from = 0, until = names.size)]))
        }
        return data
    }
}