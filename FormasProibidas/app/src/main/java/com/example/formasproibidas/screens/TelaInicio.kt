package com.example.formasproibidas.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.OutlinedButtonDefaults
import com.example.formasproibidas.R
import com.example.formasproibidas.ui.theme.FormasProibidasTheme

@Composable
fun TelaInicio(navController: NavController){

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.telalogin),
            contentDescription = "Tela com fundo azul com varias formas geometricas",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo em forma de cubo com uma parte aberta na cor laranja",
                modifier = Modifier
                    .height(345.dp)
                    .width(251.dp)
            )

            OutlinedButton(
                onClick = {
                    navController.navigate("login")
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0x60FFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(247.dp)
                    .height(58.dp)
                    .border(1.dp, Color.White, RoundedCornerShape(12.dp))

            ) {
                Text(
                    text ="Login",
                    fontSize = 36.sp,
                    color = Color(0xFFFF8A76)
                    )
            }

            Spacer(Modifier.padding(10.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("cadastro")
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0x60FFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(247.dp)
                    .height(58.dp)
                    .border(1.dp, Color.White, RoundedCornerShape(12.dp))

            ) {
                Text(
                    text = "Cadastrar",
                    fontSize = 36.sp,
                    color = Color(0xFFFF8A76)
                    )
            }
        }
    }
}

@Preview
@Composable
fun TelaInicioPreview(){
    FormasProibidasTheme {
        TelaInicio(navController = rememberNavController())
    }
}