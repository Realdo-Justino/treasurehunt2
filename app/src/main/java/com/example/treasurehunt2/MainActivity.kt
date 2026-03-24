package com.example.treasurehunt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.treasurehunt2.ui.theme.Treasurehunt2Theme

object Routes {
    const val HOME = "home"
    const val TIP1 = "tip1"
    const val TIP2 = "tip2"
    const val TIP3 = "tip3"
    const val TREASURE = "treasure"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            Treasurehunt2Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onNavigateToDetails = {
                    navController.navigate(Routes.TIP1)
                }
            )
        }

        composable(Routes.TIP1) {
            Tip1Screen (
                onNextTip = {
                    navController.navigate(Routes.TIP2)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.TIP2) {
            Tip2Screen (
                onNextTip = {
                    navController.navigate(Routes.TIP3)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.TIP3) {
            Tip3Screen (
                onFinish = {
                    navController.navigate(Routes.TREASURE)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.TREASURE) {
            TreasureScreen (
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun HomeScreen(onNavigateToDetails: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box ( contentAlignment = Alignment.Center, modifier = Modifier .fillMaxSize() ) {
            Column ( horizontalAlignment = Alignment.CenterHorizontally ) {
                Text("Welcome to the treasure hunt,")
                Text("try to guess the character")
                Text("You will recive 3 tips")
                Button(onClick = onNavigateToDetails) {
                    Text("Start")
                }
            }
        }
    }
}

@Composable
fun Tip1Screen(onNextTip: () -> Unit, onBack: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box ( contentAlignment = Alignment.Center, modifier = Modifier .fillMaxSize() ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("First Tip: the character is purple")
                Button(onClick = onNextTip) {
                    Text("Next Tip")
                }
                Button(onClick = onBack) {
                    Text("Back")
                }
            }
        }
    }
}

@Composable
fun Tip2Screen(onNextTip: () -> Unit, onBack: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box ( contentAlignment = Alignment.Center, modifier = Modifier .fillMaxSize() ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Second Tip: the character is based on reptile")
                Button(onClick = onNextTip) {
                    Text("Next Tip")
                }
                Button(onClick = onBack) {
                    Text("Back")
                }
            }
        }
    }
}

@Composable
fun Tip3Screen(onFinish: () -> Unit, onBack: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box ( contentAlignment = Alignment.Center, modifier = Modifier .fillMaxSize() ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Third Tip: the media this character")
                Text("comes from is rated E")
                Button(onClick = onFinish) {
                    Text("See answer")
                }
                Button(onClick = onBack) {
                    Text("Back")
                }
            }
        }
    }
}

@Composable
fun TreasureScreen(onBack: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box ( contentAlignment = Alignment.Center, modifier = Modifier .fillMaxSize() ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("It's Suzie")
                Text("From deltarune")
                Image(
                    painter = painterResource(id = R.drawable.susie),
                    contentDescription = "suzie_deltarune"
                )
                Button(onClick = onBack) {
                    Text("Back")
                }
            }
        }
    }
}
