package com.estibenlicona.samsungtvremote.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estibenlicona.samsungtvremote.R
import com.estibenlicona.samsungtvremote.ir.IrController
import com.estibenlicona.samsungtvremote.ir.SamsungIrCodes

@Composable
fun RemoteScreen(irController: IrController) {
    val haptic = LocalHapticFeedback.current
    val hasIr = irController.hasIrEmitter

    fun sendCommand(command: Int) {
        haptic.performHapticFeedback(HapticFeedbackType.KeyboardPress)
        irController.transmitSamsung(command)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = stringResource(R.string.remote_title),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            if (!hasIr) {
                Text(
                    text = stringResource(R.string.no_ir_message),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Button(
                onClick = { sendCommand(SamsungIrCodes.POWER) },
                enabled = hasIr,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text(stringResource(R.string.power), fontSize = 18.sp)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                RemoteButton(
                    label = stringResource(R.string.up),
                    enabled = hasIr,
                    onClick = { sendCommand(SamsungIrCodes.UP) }
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    RemoteButton(
                        label = stringResource(R.string.left),
                        enabled = hasIr,
                        onClick = { sendCommand(SamsungIrCodes.LEFT) }
                    )
                    RemoteButton(
                        label = stringResource(R.string.ok),
                        enabled = hasIr,
                        onClick = { sendCommand(SamsungIrCodes.OK) }
                    )
                    RemoteButton(
                        label = stringResource(R.string.right),
                        enabled = hasIr,
                        onClick = { sendCommand(SamsungIrCodes.RIGHT) }
                    )
                }
                RemoteButton(
                    label = stringResource(R.string.down),
                    enabled = hasIr,
                    onClick = { sendCommand(SamsungIrCodes.DOWN) }
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                RemoteButton(
                    label = stringResource(R.string.volume_up),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.VOLUME_UP) }
                )
                RemoteButton(
                    label = stringResource(R.string.volume_down),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.VOLUME_DOWN) }
                )
                RemoteButton(
                    label = stringResource(R.string.mute),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.MUTE) }
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                RemoteButton(
                    label = stringResource(R.string.channel_up),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.CHANNEL_UP) }
                )
                RemoteButton(
                    label = stringResource(R.string.channel_down),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.CHANNEL_DOWN) }
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                RemoteButton(
                    label = stringResource(R.string.source),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.SOURCE) }
                )
                RemoteButton(
                    label = stringResource(R.string.menu),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.MENU) }
                )
                RemoteButton(
                    label = stringResource(R.string.home),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.HOME) }
                )
                RemoteButton(
                    label = stringResource(R.string.back),
                    enabled = hasIr,
                    modifier = Modifier.weight(1f),
                    onClick = { sendCommand(SamsungIrCodes.BACK) }
                )
            }
        }
    }
}

@Composable
private fun RemoteButton(
    label: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text = label)
    }
}
