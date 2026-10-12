package com.learn.dialogbox

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.learn.dialogbox.ui.theme.DialogBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialogBoxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DialogButton(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogButton(modifier: Modifier = Modifier, name: String = "Android") {

    var isDialogOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                isDialogOn = true
            }
        ) {
            Text("Show Dialog")
        }
    }
    if (isDialogOn){
        Log.d(MainActivity::class.java.name, "showDialog: ${isDialogOn}")
        AlertDialog(
            onDismissRequest = {
                isDialogOn = false
            },
            title = {Text(text = "Dialog Demo")},
            confirmButton = {
                TextButton(
                    onClick = { isDialogOn = false}
                ) {
                    Text("Close")
                }
            }
        )
    }
    Toast.makeText(LocalContext.current, "showDialog: ${isDialogOn}", Toast.LENGTH_SHORT).show()
}



