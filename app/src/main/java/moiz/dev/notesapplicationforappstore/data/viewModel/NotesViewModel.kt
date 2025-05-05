package moiz.dev.notesapplicationforappstore.data.viewModel

import android.app.Application
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import moiz.dev.notesapplicationforappstore.data.local.DatabaseProvider
import moiz.dev.notesapplicationforappstore.data.model.Note

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    private val notesDao = DatabaseProvider.getDatabase(application).notesDao()
    val allNotes =
        notesDao.getAllNotes().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun addNote(note: Note) = viewModelScope.launch {
        notesDao.insert(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        notesDao.delete(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        notesDao.update(note)
    }


}