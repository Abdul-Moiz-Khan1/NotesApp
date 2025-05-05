package moiz.dev.notesapplicationforappstore.data.local

import androidx.room.Delete
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import moiz.dev.notesapplicationforappstore.data.model.Note
import moiz.dev.notesapplicationforappstore.utils.Consts

interface NotesDao {

    suspend fun insert(note: Note)
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM  Notes ORDER BY id DESC")
    suspend fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Notes WHERE content Like '%' ||:query OR title = :query")
    suspend fun searchNotes(query: String): Flow<List<Note>>

}