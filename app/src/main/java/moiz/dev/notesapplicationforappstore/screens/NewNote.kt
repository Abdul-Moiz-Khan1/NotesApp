package moiz.dev.notesapplicationforappstore.screens

import android.app.Application
import android.widget.ScrollView
import android.widget.Scroller
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import moiz.dev.notesapplicationforappstore.R
import moiz.dev.notesapplicationforappstore.data.model.Note
import moiz.dev.notesapplicationforappstore.data.viewModel.NotesViewModel
import moiz.dev.notesappplaystore.utils.Routes

@Composable
fun NewNote(navController: NavController,viewModel:NotesViewModel) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var tag by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 24.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.back),
            null,
            modifier = Modifier
                .clickable { navController.popBackStack() })
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "New Note",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
            )
            TextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
            )
            TextField(
                value = tag,
                onValueChange = { tag = it },
                label = { Text("Importance/Grocery/Todo List if any") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
            )
            Spacer(modifier = Modifier.size(64.dp))
            Button(onClick = {
                viewModel.addNote(Note(0, title, content, tag, "", "00:00"))
                Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                navController.popBackStack()
            }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Add")
            }
        }


    }
}