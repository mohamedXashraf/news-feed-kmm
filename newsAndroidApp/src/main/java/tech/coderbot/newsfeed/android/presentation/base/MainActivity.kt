package tech.coderbot.newsfeed.android.presentation.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tech.coderbot.newsfeed.android.presentation.details.Details
import tech.coderbot.newsfeed.android.presentation.home.Home
import tech.coderbot.newsfeed.android.utils.Constants.HOME
import tech.coderbot.newsfeed.android.utils.Constants.DETAILS

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent { Application() }
    }
}

@Composable
fun Application()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME, builder = {
        composable(HOME, content = { Home(navController) })
        composable("$DETAILS/{id}",
            arguments = listOf(navArgument("id", builder = {
                    type = NavType.StringType
            })),
            content = { Details(navController, it.arguments?.getString("id") ?: "") }
        )
    })
}