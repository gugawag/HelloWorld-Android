package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartaoMensagem(mensagem = "Hello World!")
                }
            }
        }
    }
}

@Composable
fun CartaoMensagem(mensagem: String, modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    Row {
        Column {
            MensagemHello(mensagem = mensagem, modifier = modifier)
            MensagemHello(mensagem = text, modifier = modifier)
        }
        Column {

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Digite algo") }
            )
        }
    }

}

@Composable
fun MensagemHello(mensagem: String, modifier: Modifier = Modifier) {
    Text(
        text = mensagem,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        CartaoMensagem(mensagem = "Hello World!")
    }
}