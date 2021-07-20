package blog.mateuszgrabarski.gradle.configuration

interface Configuration {
    val intField: Int
    val apiUrl: String
    val debug: Boolean
    val defaultColor: ColorEnum
}

class Stage : Configuration {
    override val intField: Int
        get() = 5

    override val apiUrl: String
        get() = "www.staging.com"

    override val debug: Boolean
        get() = true

    override val defaultColor: ColorEnum
        get() = ColorEnum.Black
}

class Production : Configuration {
    override val intField: Int
        get() = 10

    override val apiUrl: String
        get() = "www.production.com"

    override val debug: Boolean
        get() = false

    override val defaultColor: ColorEnum
        get() = ColorEnum.Red
}

enum class ColorEnum {
    Red, Black
}