package com.agronomia.planilla.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.agronomia.planilla.ui.screens.HomeScreen
import com.agronomia.planilla.ui.screens.modules.SiembraGranosScreen
import com.agronomia.planilla.ui.screens.modules.ConversionUnidadesScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable(
            route = "module/{moduleId}/{moduleTitle}",
            arguments = listOf(
                navArgument("moduleId") { type = NavType.StringType },
                navArgument("moduleTitle") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val moduleId = backStackEntry.arguments?.getString("moduleId") ?: ""
            val moduleTitle = backStackEntry.arguments?.getString("moduleTitle") ?: ""
            
            when (moduleId) {
                "m1" -> SiembraGranosScreen(navController, moduleTitle)
                "m12" -> ConversionUnidadesScreen(navController, moduleTitle)
                else -> HomeScreen(navController)
            }
        }
    }
}
