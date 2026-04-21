package com.estibenlicona.samsungtvremote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.estibenlicona.samsungtvremote.ir.IrController
import com.estibenlicona.samsungtvremote.ui.RemoteScreen
import com.estibenlicona.samsungtvremote.ui.theme.SamsungTvRemoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SamsungTvRemoteTheme {
                val irController = remember { IrController(this) }
                RemoteScreen(irController = irController)
            }
        }
    }
}
