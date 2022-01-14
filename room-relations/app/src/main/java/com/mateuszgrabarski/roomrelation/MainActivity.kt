package com.mateuszgrabarski.roomrelation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mateuszgrabarski.roomrelation.database.entities.*
import com.mateuszgrabarski.roomrelation.database.types.Id
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Dispatchers.Main.immediate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope.launch(Dispatchers.IO) {
            val userDao = (application as App).provideUserDao()
            val identificationCardDao = (application as App).provideIdentificationCardDao()
            val postsDao = (application as App).providePostsDao()
            val tagDao = (application as App).provideTagDao()

            val user = getAnyUser()
            userDao.insert(user)

            val identificationCard = getAnyIdentificationCard(user.id)
            identificationCardDao.insert(identificationCard)

            // fetch user with identification card
            val userAndCard = userDao.getUserWithIdentificationCard(user.id.toString())
            val userAndCardMultimap =
                userDao.getUserWithIdentificationCardMultimap(user.id.toString())

            // insert some posts for user
            val post1 = anyPost(user.id)
            postsDao.insert(post1)
            val post2 = anyPost(user.id)
            postsDao.insert(post2)
            postsDao.insert(anyPost(user.id))

            // fetch user with all posts for that user
            val userPosts = postsDao.getUserPosts(user.id.toString())
            val userPostsMultimap = postsDao.getUserPostsMultimap(user.id.toString())

            // insert tags and mark tag with post
            val tag1 = anyTag()
            val tag2 = anyTag()
            tagDao.insert(tag1)
            tagDao.insert(tag2)

            // post one has two tags
            tagDao.insert(getPostAndTagRef(post1.id, tag1.id))
            tagDao.insert(getPostAndTagRef(post1.id, tag2.id))

            // post two has one tag
            tagDao.insert(getPostAndTagRef(post2.id, tag1.id))

            Log.d("asdf", "onCreate: ${tagDao.getPostWithTags(post1.id.toString())}")
            Log.d("asdf", "onCreate: ${tagDao.getPostWithTagsMultimap(post1.id.toString())}")

            Log.d("asdf", "onCreate: ${tagDao.getPostWithTags(post2.id.toString())}")
            Log.d("asdf", "onCreate: ${tagDao.getPostWithTagsMultimap(post2.id.toString())}")
        }
    }

    private fun getPostAndTagRef(postId: Id, tagId: Id) = PostAndTagRef(
        postId = postId,
        tagId = tagId
    )

    private fun anyTag() = Tag(
        id = Id.randomUUID(),
        name = "name ${Random.nextInt()}"
    )

    private fun anyPost(userId: Id) = Post(
        id = Id.randomUUID(),
        title = "any title ${Random.nextInt()}",
        content = "any content ${Random.nextInt()}",
        userId = userId
    )

    private fun getAnyIdentificationCard(userId: Id) = IdentificationCard(
        id = Id.randomUUID(),
        pesel = "some number",
        identificationCardNumber = "some id",
        userId = userId
    )

    private fun getAnyUser() = User(
        id = Id.randomUUID(),
        loginData = LoginData(
            loginUserName = "loginUserName",
            password = "password"
        ),
        basicInfo = BasicInfo(
            firstName = "firstName",
            lastName = "lastName"
        ),
        contactInfo = ContactInfo(
            email = "email",
            phone = "phone"
        ),
        createDate = Date()
    )
}