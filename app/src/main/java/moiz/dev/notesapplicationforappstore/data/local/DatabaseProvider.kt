package moiz.dev.notesapplicationforappstore.data.local

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    @Volatile private var Instance:Database? = null

    fun getDatabase(context:Context):Database{
            return Instance?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    "note_database"
                ).build().also { Instance = it }
            }
    }
}