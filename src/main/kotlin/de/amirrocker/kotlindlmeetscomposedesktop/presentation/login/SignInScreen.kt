package de.amirrocker.kotlindlmeetscomposedesktop.presentation.login

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInScreen() {

    var username:String by remember { mutableStateOf("") }
    var password:String by remember { mutableStateOf("") }
    var staySignedIn:Boolean by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        TextField(
            value=username,
            onValueChange = { newValue: String ->  username = newValue },
            modifier = Modifier.padding(horizontal = 8.dp).weight(1f),
            placeholder = { "Enter Username" },
            leadingIcon = { Icon(Icons.Filled.Add, "Add Icon - should be username")},
            label = { Text(text = "Bitte username eintragen")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value=password,
            onValueChange = { newValue: String ->  password = newValue },
            modifier = Modifier.padding(horizontal = 8.dp).weight(1f),
            placeholder = { "Enter Password" },
            leadingIcon = { Icon(Icons.Filled.Add, "Add Icon - should be username")},
            label = { Text(text = "Bitte Passwort eintragen")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(text = "Stay signed in")
            Switch(checked = staySignedIn, onCheckedChange = { newValue -> staySignedIn = newValue })
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { println("Login button clicked") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Sign me in")
        }
    }

}


@Composable
@Preview
fun SignInScreenPreview() {
    SignInScreen()
}