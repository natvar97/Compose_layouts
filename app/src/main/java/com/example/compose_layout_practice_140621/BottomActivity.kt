package com.example.compose_layout_practice_140621

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_layout_practice_140621.bottomnavigationbar.Scaffold
import com.example.compose_layout_practice_140621.ui.theme.Compose_layout_practice_140621Theme

class BottomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_layout_practice_140621Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold().AppScaffold()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    Compose_layout_practice_140621Theme {
        Scaffold().AppScaffold()
    }
}