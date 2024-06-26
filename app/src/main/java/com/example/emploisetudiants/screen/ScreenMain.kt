package com.example.emploisetudiants.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.emploisetudiants.Routes
import com.example.emploisetudiants.SampleData

@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }
        composable(Routes.SignUp.route) {
            SignUp(navController = navController)
        }
        composable(Routes.CompanyList.route) {
            CompanyList(messages = SampleData.conversationSample, navController = navController)
        }
        composable(
            route = Routes.OfferDetails.route + "/{offerID}",
            arguments = listOf(
                navArgument("offerID") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            OfferDetails(offerID = entry.arguments?.getString("offerID"), navController = navController)
        }
    }
}
