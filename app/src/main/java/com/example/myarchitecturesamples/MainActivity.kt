package com.example.myarchitecturesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.homelist.ui.HomeListRoot
import com.example.myarchitecturesamples.ui.theme.MyArchitectureSamplesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            MyArchitectureSamplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeListRoot(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {  }
    Text(
        text = "Hello $name!",
        modifier = modifier
    )


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyArchitectureSamplesTheme {
        Greeting("Android")
    }
}