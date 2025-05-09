package moiz.dev.notesapplicationforappstore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import moiz.dev.notesapplicationforappstore.data.model.Note

@Database(entities = [Note::class], version = 1 , exportSchema = false)
abstract class Database:RoomDatabase() {
    abstract fun notesDao(): NotesDao
}