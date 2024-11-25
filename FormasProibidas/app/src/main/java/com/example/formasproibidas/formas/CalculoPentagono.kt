package com.example.formasproibidas.formas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.formasproibidas.R
import com.example.formasproibidas.funcoes.direcionandoSite
import com.example.formasproibidas.ui.theme.FormasProibidasTheme
import kotlin.math.PI
import kotlin.math.tan


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCalculoPentagono(navController: NavController){

    val gradient = Brush.linearGradient(
        0.0f to Color(0x80FFFFFF),
        500.0f to Color(0x00999999),
        start = Offset.Zero,
        end = Offset.Infinite
    )


    var areaText by remember{ mutableStateOf("") }
    var resultadoText by remember { mutableStateOf("") }

    //Box usando como background.
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

        //Box recebendo todos os elementos.
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize()
        ){

            //Coluna alinhando todos os elementos dentro do box.
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {

                //Box do cubo.
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .width(260.dp)
                        .height(260.dp)
                        .background(gradient)
                ){
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Pentagono",
                            fontSize = 40.sp,
                            color = Color(0xFFFF8A76)
                        )

                        direcionandoSite("https://pt.wikipedia.org/wiki/Pol%C3%ADgono#Quanto_ao_n%C3%BAmero_de_lados")
                    }
                }

                Spacer(modifier = Modifier.padding(30.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    //TextFielld para receber informação do usuario.
                    TextField(
                        value = areaText,
                        onValueChange = {areaText = it},
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        label = {
                            Text(
                                "Aresta",
                                color = Color.White
                            )
                        },
                        modifier = Modifier
                            .width(120.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.White
                        ),
                        singleLine = true
                    )
                    //TextFielld para mostrar o resultado para o usuario.
                    TextField(
                        value = resultadoText,
                        onValueChange = {

                        },
                        label = { Text("Resultado", color = Color.White)},
                        modifier = Modifier
                            .width(120.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        ),
                        readOnly = true
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    onClick = {
                        val lado = areaText.toDoubleOrNull()
                        if(lado != null && lado > 0){
                            val apotema = lado / (2 * tan(PI / 5))
                            val areaFinal = (5 * lado * apotema) / 2
                            resultadoText = "%.2f".format(areaFinal)

                        } else {
                            resultadoText = "Não entendi..."
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0x40FFFFFF)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(247.dp)
                        .height(58.dp)
                        .border(2.dp,Color.White, RoundedCornerShape(12.dp))
                ){
                    Text(
                        "Calcular",
                        fontSize = 28.sp,
                        color = Color(0xFFFF8A76)
                    )
                }


                Spacer(modifier = Modifier.padding(50.dp))

                //Box com botão voltar e menu principal.
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Button(
                            onClick = {
                                navController.navigate("home/{name}")
                            },
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color(0x40FFFFFF)
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .width(108.dp)
                                .height(44.dp)
                                .border(2.dp,Color.White, RoundedCornerShape(12.dp))

                        ) {
                            Text(
                                text = "Voltar",
                                fontSize = 20.sp,
                                color = Color(0xFFFF8A76)
                            )
                        }
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(70.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF1A206A))
                        ){
                            Image(
                                painter = painterResource(R.drawable.baseline_menu_24),
                                contentDescription = "Três barras para simular o menu",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        navController.navigate("menuprincipal")
                                    }
                            )
                        }
                    }
                }
            }
        }
    }

}


@Composable
@Preview
fun TelaCalculoPentagonoPreview(){
    FormasProibidasTheme {
        TelaCalculoPentagono(navController = rememberNavController())
    }
}