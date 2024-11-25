@file:OptIn(ExperimentalMaterial3Api::class)

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
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
fun Cadastro(navController: NavController){

    val gradient = Brush.linearGradient(
        0.0f to Color(0x80FFFFFF),
        500.0f to Color(0x00999999),
        start = Offset.Zero,
        end = Offset.Infinite
    )

    var name by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var confirmarSenhaError by remember { mutableStateOf<String?>(null) }
    var nameError by remember { mutableStateOf<String?>(null) }
    var senhaError by remember { mutableStateOf<String?>(null) }
    var isLoginEnabled by remember { mutableStateOf(false) }

    fun validateForm() {
        isLoginEnabled = nameError == null && senhaError == null && name.isNotBlank() && senha.length >= 6
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.telalogin),
            contentDescription = "Tela com fundo azul com varias formas geometricas",
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(gradient)
                .width(284.dp)
                .height(378.dp)
        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        nameError = if(name.isBlank()) "O nome não pode estar vazio" else null
                        validateForm()
                        },
                    label = { Text("Nome:") },
                    isError = nameError != null,
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0x0FFFFFFF)
                    )
                )

                if(nameError != null){
                    Text(nameError?: "", color = MaterialTheme.colorScheme.error)
                }

                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text("Email:") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0x0FFFFFFF)
                    )
                )
                TextField(
                    value = senha,
                    onValueChange = {
                        senha = it
                        senhaError = when{
                            senha.isBlank() -> "A senha não pode estar vazia"
                            senha.length < 6 -> "A senha deve ter pelo menos 6 caracteres"
                            else -> null
                        }
                        validateForm()
                    },
                    label = { Text("Senha:") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0x0FFFFFFF)
                    )
                )
                TextField(
                    value = confirmarSenha,
                    onValueChange = {
                        confirmarSenha = it
                        confirmarSenhaError = when{
                            confirmarSenha != senha -> "A senha tem que ser iguais"
                            else -> null
                        }
                        validateForm()
                    },
                    label = { Text("Confirmar senha:") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0x0FFFFFFF)
                    )
                )

                Spacer(Modifier.padding(16.dp))

                OutlinedButton(
                    onClick = {
                        if(isLoginEnabled){
                            navController.navigate("home/${name}")
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0x40FFFFFF)
                    ),
                    shape = RoundedCornerShape(size = 12.dp),
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
}

@Composable
@Preview
fun CadastroPreview(){
    Cadastro(navController = rememberNavController())
}