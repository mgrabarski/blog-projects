import org.gradle.api.JavaVersion

object ApplicationConfig {

    val compileSdkVersion = 30
    val minSdkVersion = 23
    val targetSdkVersion = 30
    val versionCode = 1
    val versionName = "0.0.1"
}

object Flavours {

    val productionApplicationId = "blog.mateuszgrabarski.gradlekotlin"
    val stageApplicationId = "blog.mateuszgrabarski.gradlekotlin.stage"
}

object Java {

    val java_version = JavaVersion.VERSION_1_8
}