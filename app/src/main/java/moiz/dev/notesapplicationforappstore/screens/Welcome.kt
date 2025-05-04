package moiz.dev.notesapplicationforappstore.screens

import android.content.Context
import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavController
import moiz.dev.notesapplicationforappstore.R
import moiz.dev.notesapplicationforappstore.data.local.PreferenceHelper
import moiz.dev.notesappplaystore.utils.Routes
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Welcome(navController: NavController) {
    val context = LocalContext.current
    val prefs = remember { PreferenceHelper(context) }
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

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Your Digital Notebook, Always With You!",
                modifier = Modifier
                    .padding(bottom = 8.dp),
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFFF8383)
            )
            Text(
                "Sync. Save. Simplify.",
                modifier = Modifier
                    .padding(bottom = 60.dp),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFFF8383)
            )
        }
        Button(
            onClick = {
                navController.navigate(Routes.HOME) {
                    prefs.setWelcome(true)
                    popUpTo(Routes.WELCOME) { inclusive = true }
                }

            },
            modifier = Modifier
                .padding(end = 32.dp, bottom = 48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF86B4BD),
                    contentColor = Color.White
                )
        ) { Text("Get Started") }
    }
}