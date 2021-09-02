package blog.mateuszgrabarski.typeconverters.database.converters

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat.PNG
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class BitmapConverter {

    @TypeConverter
    fun fromBytesToBitmap(bytes: ByteArray): Bitmap =
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

    @TypeConverter
    fun fromBitmapToBytes(bmp: Bitmap): ByteArray =
        ByteArrayOutputStream().apply {
            bmp.compress(PNG, 100, this)
        }.toByteArray()
}