package com.example.catsMVIFlow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel // Importar solo una vez

import dagger.hilt.android.AndroidEntryPoint

import com.example.catsMVIFlow.presentation.theme.CatsTheme
import com.example.catsMVIFlow.presentation.ui.screens.CatFactScreen
import com.example.catsMVIFlow.presentation.viewmodels.MainViewModel // Dejar solo una importación

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: MainViewModel = hiltViewModel()
                    CatFactScreen(catFact = viewModel.uiState) {
                        viewModel.getCatFact()
                    }
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CatsTheme {
        Greeting("Android")
    }
}
