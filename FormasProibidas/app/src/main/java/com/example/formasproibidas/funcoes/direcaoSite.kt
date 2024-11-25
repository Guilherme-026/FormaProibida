package com.example.formasproibidas.funcoes

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun direcionandoSite(url: String){

    val context = LocalContext.current

    Button(onClick = {
        // Criando o Intent para abrir o link
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent) },
        modifier = Modifier
            .background(Color.Transparent),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color(0x6000A8FF)
        )
    ) {
        Text(text = "Mais sobre a forma")
    }
}

@Composable
@Preview
fun preview(){
    direcionandoSite("www.youtube.com")
}