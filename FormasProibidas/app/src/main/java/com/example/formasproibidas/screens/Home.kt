package com.example.formasproibidas.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.formasproibidas.R
import com.example.formasproibidas.funcoes.UserViewModel
import com.example.formasproibidas.ui.theme.FormasProibidasTheme


@Composable
fun TelaHome(navController: NavController, userViewModel: UserViewModel = viewModel()) {

    val nome = userViewModel.nome.value

    val gradient = Brush.linearGradient(
        0.0f to Color(0x80FFFFFF),
        500.0f to Color(0x00999999),
        start = Offset.Zero,
        end = Offset.Infinite
    )

    //Box sendo usado como background.
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.teladownload),
            contentDescription = "Forma geometrica em tons de azul",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
        )

        //Box aonde todo os elementos estão.
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize()
        ) {

            //Coluna para deixar os elementos um embaixo do outro.
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight()
            ) {

                //Simbolo de perfil, mensagem de bem-vindo e nome do usuario.
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 100.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF999999))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.icon_perfil),
                            contentDescription = "Perfil",
                            modifier = Modifier
                                .size(55.dp)
                        )
                    }

                    Spacer(modifier = Modifier.padding(8.dp))

                    Column(
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Bem-Vindo(a)",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "$nome",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }
                }

                //Coluna para alinhar as linhas das formas uma embaixo da outra.
                Column(
                    modifier = Modifier
                        .padding(top = 95.dp)
                        .horizontalScroll(ScrollState(0)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {

                    //Primeira linha das formas
                    Row {
                        //Box do Cubo
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Cubo",
                                    fontSize = 36.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {
                                        navController.navigate("calculoCubo")
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.padding(12.dp))

                        //Box do Círculo
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Círculo",
                                    fontSize = 36.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {
                                        navController.navigate("calculoCirculo")
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.padding(12.dp))

                        //Box do Trapezoide Irregular
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Trapezoide",
                                    fontSize = 28.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {
                                        navController.navigate("calculoTrapezoide")
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.padding(12.dp))

                        //Box do Pentagono
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Pentágono",
                                    fontSize = 28.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {
                                        navController.navigate("calculopentagono")
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(10.dp))

                    //Segunda linha das formas
                    Row {
                        //Box do Romboedro
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Romboedro",
                                    fontSize = 26.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {
                                        navController.navigate("calculoRomboedro")
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.padding(12.dp))

                        //Box do Retângulo
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = "Retângulo",
                                    fontSize = 28.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {
                                        navController.navigate("calculoRetangulo")
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.padding(12.dp))

                        //Box do Quadrado
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Quadrado",
                                    fontSize = 28.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {
                                        navController.navigate("")
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.padding(12.dp))

                        //Box do Cubóide
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .width(150.dp)
                                .height(150.dp)
                                .background(gradient)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Cubóide",
                                    fontSize = 36.sp,
                                    color = Color(0xFFFF8A76),
                                    modifier = Modifier.clickable {

                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(40.dp))

                //Box onde vai ficar o menu principal
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF1A206A))
                        .align(Alignment.End)
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_menu_24),
                        contentDescription = "Três barras para simular o menu",
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                navController.navigate("menuPrincipal")
                            }
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun TelaHomePreview() {
    FormasProibidasTheme {
        TelaHome(navController = rememberNavController())
    }
}