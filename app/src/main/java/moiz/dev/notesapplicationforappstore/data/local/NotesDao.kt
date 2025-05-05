package moiz.dev.notesapplicationforappstore.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import moiz.dev.notesapplicationforappstore.data.model.Note

@Dao
interface NotesDao {

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM  Notes ORDER BY id DESC")
     fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Notes WHERE content Like '%' ||:query || '%' OR title Like '%' ||:query || '%'")
     fun searchNotes(query: String): Flow<List<Note>>

    @Query("SELECT * FROM Notes WHERE date=:date")
     fun getNotesByDate(date: String): Flow<List<Note>>

    @Query("SELECT * FROM Notes WHERE tag=:tag")
    fun getNotesByTag(tag: String): Flow<List<Note>>

    @Query("SELECT tag FROM Notes")
    fun getTags(): List<String>

}