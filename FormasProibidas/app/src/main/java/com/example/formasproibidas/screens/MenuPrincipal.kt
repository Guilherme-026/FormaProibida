package com.example.formasproibidas.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.formasproibidas.R

@Composable
fun MenuPrincipal(navController: NavController){

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.teladownload),
            contentDescription = "Forma geometrica em tons de azul",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Text(
                "MENU PRINCIPAL",
                fontSize = 30.sp,
                color = Color.White,
            )

            //Botão Home
            Button(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0x40FFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(247.dp)
                    .height(58.dp)
                    .border(2.dp,Color.White, RoundedCornerShape(12.dp))

            ) {
                Text(
                    text = "Home",
                    fontSize = 28.sp,
                    color = Color(0xFFFF8A76)
                )
            }
            //Botão Perfil
            Button(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0x40FFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(247.dp)
                    .height(58.dp)
                    .border(2.dp,Color.White, RoundedCornerShape(12.dp))

            ) {
                Text(
                    text = "Perfil",
                    fontSize = 28.sp,
                    color = Color(0xFFFF8A76)
                )
            }
            //Botão Formas
            Button(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0x40FFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(247.dp)
                    .height(58.dp)
                    .border(2.dp,Color.White, RoundedCornerShape(12.dp))

            ) {
                Text(
                    text = "Formas",
                    fontSize = 28.sp,
                    color = Color(0xFFFF8A76)
                )
            }
            //Botão Termos de Uso
            Button(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0x40FFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(247.dp)
                    .height(58.dp)
                    .border(2.dp,Color.White, RoundedCornerShape(12.dp))

            ) {
                Text(
                    text = "Termos de Uso",
                    fontSize = 28.sp,
                    color = Color(0xFFFF8A76)
                )
            }
            //Botão Logout
            Button(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0x40FFFFFF)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(247.dp)
                    .height(58.dp)
                    .border(2.dp,Color.White, RoundedCornerShape(12.dp))

            ) {
                Text(
                    text = "Logout",
                    fontSize = 28.sp,
                    color = Color(0xFFFF8A76)
                )
            }

            Box(
               modifier = Modifier
                   .fillMaxWidth()
            ){
                //Botão Voltar
                Button(
                    onClick = {
                        navController.navigate("home")
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0x40FFFFFF)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(108.dp)
                        .height(44.dp)
                        .border(2.dp,Color.White, RoundedCornerShape(12.dp))
                        .align(Alignment.CenterStart)

                ) {
                    Text(
                        text = "Voltar",
                        fontSize = 20.sp,
                        color = Color(0xFFFF8A76)
                    )
                }
            }
        }
    }

}


@Composable
@Preview
fun MenuPrincipalPreview(){
    MenuPrincipal(navController = rememberNavController())
}