package com.example.formasproibidas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.formasproibidas.screens.Cadastro
import com.example.formasproibidas.screens.TelaHome
import com.example.formasproibidas.screens.Login
import com.example.formasproibidas.screens.MenuPrincipal
import com.example.formasproibidas.formas.TelaCalculoCirculo
import com.example.formasproibidas.formas.TelaCalculoCubo
import com.example.formasproibidas.formas.TelaCalculoCuboide
import com.example.formasproibidas.formas.TelaCalculoPentagono
import com.example.formasproibidas.formas.TelaCalculoQuadrado
import com.example.formasproibidas.formas.TelaCalculoRetangulo
import com.example.formasproibidas.formas.TelaCalculoRomboedro
import com.example.formasproibidas.formas.TelaCalculoTrapezoide
import com.example.formasproibidas.screens.TelaInicio
import com.example.formasproibidas.ui.theme.FormasProibidasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormasProibidasTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "telainicio") {
                    composable(
                        "telainicio"
                    ) {
                        TelaInicio(navController)
                    }
                    composable(
                        "login"
                    ) {
                        Login(navController)
                    }
                    composable(
                        "cadastro"
                    ){
                        Cadastro(navController)
                    }
                    composable(
                        "home"
                    ){
                        TelaHome(navController)
                    }
                    composable(
                        "menuPrincipal"
                    ){
                        MenuPrincipal(navController)
                    }
                    composable("calculoCubo"){
                        TelaCalculoCubo(navController)
                    }
                    composable("calculoCirculo"){
                        TelaCalculoCirculo(navController)
                    }
                    composable(
                        "calculoRomboedro"
                    ){
                        TelaCalculoRomboedro(navController)
                    }
                    composable(
                        "calculoRetangulo"
                    ){
                        TelaCalculoRetangulo(navController)
                    }
                    composable(
                        "calculoTrapezoide"
                    ) {
                        TelaCalculoTrapezoide(navController)
                    }
                    composable(
                        "calculoPentagono"
                    ){
                        TelaCalculoPentagono(navController)
                    }
                    composable(
                        "calculoCuboide"
                    ){
                        TelaCalculoCuboide(navController)
                    }
                    composable(
                        "calculoQuadrado"
                    ) {
                        TelaCalculoQuadrado(navController)
                    }
                }
            }
        }
    }
}