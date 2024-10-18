package ru.plodushcheva.newella

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.plodushcheva.newella.main.ui.MainScreen
import ru.plodushcheva.newella.ui.theme.NewellaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewellaTheme {
                MainScreen()
            }
        }
    }
}
