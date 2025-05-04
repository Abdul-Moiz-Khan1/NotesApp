package moiz.dev.notesapplicationforappstore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import moiz.dev.notesapplicationforappstore.R
import moiz.dev.notesappplaystore.utils.Routes

@Composable
fun NewNote(navController: NavController) {
    Image(
        painter = painterResource(R.drawable.back),
        null,
        modifier = Modifier
            .padding(start = 16.dp, top = 24.dp)
            .clickable { navController.popBackStack() })
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) { Text("New Note", fontSize = 36.sp) }
}