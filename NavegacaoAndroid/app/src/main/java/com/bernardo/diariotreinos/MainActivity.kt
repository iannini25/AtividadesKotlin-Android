package com.bernardo.diariotreinos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.bernardo.diariotreinos.navegacao.AppNavegacao
import com.bernardo.diariotreinos.ui.theme.TemaTreinos

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemaTreinos {
                Surface {
                    AppNavegacao()
                }
            }
        }
    }
}
