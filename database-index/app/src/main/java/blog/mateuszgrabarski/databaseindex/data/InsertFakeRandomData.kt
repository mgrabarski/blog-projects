package blog.mateuszgrabarski.databaseindex.data

import blog.mateuszgrabarski.databaseindex.data.generator.DataGenerator
import blog.mateuszgrabarski.databaseindex.database.dao.UserDao

class InsertRandomData(
    private val fakeDataGenerator: DataGenerator
) {

    suspend fun generateAndInsertRandomData(numberOfMillions: Int, userDao: UserDao) {
        repeat(numberOfMillions) {
            val fakeData = fakeDataGenerator.generate()
            userDao.insert(fakeData)
        }
    }
}