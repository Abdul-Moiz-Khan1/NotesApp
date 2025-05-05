package moiz.dev.notesapplicationforappstore.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import moiz.dev.notesapplicationforappstore.utils.Consts

@Entity(tableName = Consts.TABLE_NAME)
data class Note(
   @PrimaryKey(autoGenerate = true) val id:Int = 0,
   val title:String,
   val content:String,
   val tag:String,
   val date:String,
   val time:String
)
