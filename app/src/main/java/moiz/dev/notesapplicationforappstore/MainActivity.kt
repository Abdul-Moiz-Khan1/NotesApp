package moiz.dev.notesapplicationforappstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import moiz.dev.notesapplicationforappstore.screens.EditNotes
import moiz.dev.notesapplicationforappstore.screens.Home
import moiz.dev.notesapplicationforappstore.screens.NewNote
import moiz.dev.notesapplicationforappstore.screens.Splash
import moiz.dev.notesapplicationforappstore.screens.Welcome
import moiz.dev.notesapplicationforappstore.ui.theme.NotesApplicationForAppStoreTheme
import moiz.dev.notesappplaystore.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesApplicationForAppStoreTheme {
                val navController = rememberNavController()
                NotesNavHost(navController)
            }
        }
    }
}
@Composable
fun NotesNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) { Splash(navController) }
        composable(Routes.WELCOME) { Welcome(navController) }
        composable(Routes.HOME) { Home(navController) }
        composable(Routes.EDIT) { EditNotes(navController) }
        composable(Routes.NEW) { NewNote(navController) }
    }
}