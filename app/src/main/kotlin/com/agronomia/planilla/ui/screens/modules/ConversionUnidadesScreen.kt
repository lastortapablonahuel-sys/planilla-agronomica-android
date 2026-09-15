package com.agronomia.planilla.ui.screens.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ConversionUnidadesScreen(navController: NavController, title: String) {
    var kg by remember { mutableStateOf("") }
    var qq by remember { mutableStateOf("") }
    var t by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFff4f7f6))
    ) {
        // Header
        TopAppBar(
            title = { Text(title, color = Color.White, fontSize = 14.sp) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF0f172a)
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Ingresá un valor y se calculan las demás equivalencias",
                fontSize = 12.sp,
                color = Color(0xFF64748b),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                color = Color.White,
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 2.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    ConversionInputRow("Kilos (kg)", kg, { newValue ->
                        kg = newValue
                        if (newValue.isNotEmpty()) {
                            val kgValue = newValue.toDoubleOrNull() ?: 0.0
                            qq = (kgValue / 100).toString()
                            t = (kgValue / 1000).toString()
                        } else {
                            qq = ""
                            t = ""
                        }
                    })

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    ConversionInputRow("Quintales (qq)", qq, { newValue ->
                        qq = newValue
                        if (newValue.isNotEmpty()) {
                            val qqValue = newValue.toDoubleOrNull() ?: 0.0
                            kg = (qqValue * 100).toString()
                            t = (qqValue / 10).toString()
                        } else {
                            kg = ""
                            t = ""
                        }
                    })

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    ConversionInputRow("Toneladas (t)", t, { newValue ->
                        t = newValue
                        if (newValue.isNotEmpty()) {
                            val tValue = newValue.toDoubleOrNull() ?: 0.0
                            kg = (tValue * 1000).toString()
                            qq = (tValue * 10).toString()
                        } else {
                            kg = ""
                            qq = ""
                        }
                    })
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Referencia rápida
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFfefce8),
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Conversión Rápida",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0f172a)
                    )
                    Text("1 qq = 100 kg", fontSize = 10.sp, color = Color(0xFF475569))
                    Text("1 t = 1000 kg", fontSize = 10.sp, color = Color(0xFF475569))
                    Text("1 t = 10 qq", fontSize = 10.sp, color = Color(0xFF475569))
                }
            }
        }
    }
}

@Composable
fun ConversionInputRow(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            label,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF475569)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .width(120.dp)
                .height(40.dp),
            textStyle = LocalTextStyle.current.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right,
                color = Color(0xFF064e3b)
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFEFCE8),
                unfocusedContainerColor = Color(0xFFFEFCE8),
                focusedIndicatorColor = Color(0xFF10b981),
                unfocusedIndicatorColor = Color(0xFFFEF08A)
            ),
            shape = RoundedCornerShape(6.dp)
        )
    }
}
