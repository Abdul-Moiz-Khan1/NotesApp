package moiz.dev.notesapplicationforappstore.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavController
import moiz.dev.notesapplicationforappstore.R
import moiz.dev.notesappplaystore.utils.Routes

@Composable
fun Welcome(navController: NavController) {

    Image(
        painter = painterResource(R.drawable.welcome_wall),
        null,
        modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth
    )
    Image(
        painter = painterResource(R.drawable.welcome_person),
        null,
        modifier = Modifier
            .fillMaxWidth()
            .size(500.dp)
            .padding(top = 200.dp)
    )

    Column(modifier = Modifier.fillMaxSize().padding(end = 32.dp , bottom = 32.dp), verticalArrangement = Arrangement.Bottom , horizontalAlignment = Alignment.End ) {
        Button(onClick = {
            navController.navigate(Routes.HOME){
                popUpTo(Routes.WELCOME){inclusive = true}
            }

        }) { Text("Get Started") }
    }

}