package org.ucb.appp2.signin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SigninScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("")}
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(20.dp),

        Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SIGNIN")
        TextField( value = email,  onValueChange = { it -> email = it },
            modifier = Modifier.fillMaxWidth())
        TextField(value = password, onValueChange = { password = it},
            modifier = Modifier.fillMaxWidth())
        Button(onClick = {

        }, modifier = Modifier.fillMaxWidth()) {
            Text("SignIn")
        }
    }
}