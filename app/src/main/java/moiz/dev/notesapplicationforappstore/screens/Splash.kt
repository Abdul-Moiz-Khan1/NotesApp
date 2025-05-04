package moiz.dev.notesapplicationforappstore.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import moiz.dev.notesapplicationforappstore.R
import moiz.dev.notesapplicationforappstore.data.local.PreferenceHelper
import moiz.dev.notesappplaystore.utils.Routes

@Composable
fun Splash(navController: NavController) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = 1)
    val context = LocalContext.current
    val prefs = remember { PreferenceHelper(context) }
    val toWelcome = prefs.isWelcome()

    LaunchedEffect(key1 = progress) {
        if (progress >= 1f && !toWelcome) {
            navController.navigate(Routes.WELCOME) {
                popUpTo(Routes.SPLASH) { inclusive = true }
            }
        } else if (progress >= 1f) {
            navController.navigate(Routes.HOME) {
                popUpTo(Routes.SPLASH) {
                    inclusive = true
                }
            }

        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress }, modifier = Modifier.size(400.dp)
        )
    }


}