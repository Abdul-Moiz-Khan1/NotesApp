package moiz.dev.notesapplicationforappstore.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferenceHelper(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun isWelcome():Boolean{
        return sharedPreferences.getBoolean("isWelcome", false)
    }

    fun setWelcome(value:Boolean){
        sharedPreferences.edit { putBoolean("isWelcome" , value) }
    }

}