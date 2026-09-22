package com.example.informeidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.informeidade.ui.theme.InformeIdadeTheme

// Cores baseadas na print
val RoxoTexto = Color(0xFF5C5FE0)
val RoxoBotao = Color(0xFF5B5FC7)
val FundoTela = Color(0xFFF5F3FA)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InformeIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaInicial(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TelaInicial(modifier: Modifier = Modifier) {
    var idade by remember { mutableIntStateOf(value = 17) }

    val identificacao = if (idade < 18) "MENOR" else "MAIOR"

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = FundoTela)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Qual é a sua idade?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = RoxoTexto
        )
        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 16.sp,
            color = Color.DarkGray
        )

        Text(
            text = "$idade",
            fontSize = 48.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { if (idade > 0) idade-- },
                colors = ButtonDefaults.buttonColors(
                    containerColor = RoxoBotao,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(72.dp)
            ) {
                Icon(imageVector = Icons.Default.Remove, contentDescription = "Diminuir")
            }

            Button(
                onClick = { if (idade < 180) idade++ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = RoxoBotao,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(72.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Aumentar")
            }
        }

        Text(
            text = "Você é $identificacao de idade",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = RoxoTexto,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InformeIdadeTheme {
        TelaInicial()
    }
}