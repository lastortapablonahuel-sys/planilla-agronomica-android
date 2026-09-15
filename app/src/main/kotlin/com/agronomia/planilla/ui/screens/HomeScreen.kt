package com.agronomia.planilla.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Module(
    val id: String,
    val title: String,
    val subtitle: String,
    val emoji: String
)

val modules = listOf(
    Module("m1", "Siembra\n(Granos)", "kg/ha · sem/m", "🌱"),
    Module("m2", "Siembra\n(Forrajeras)", "kg/ha · VC", "🌾"),
    Module("m3", "Engranajes\nde Sembradora", "piñones", "⚙️"),
    Module("m4", "Curado\nde Semilla", "cc/100 kg", "💧"),
    Module("m5", "Formulación\nde Fertilizantes", "mezcla física", "🧪"),
    Module("m6", "Unidades\nde Fertilizante", "kg N-P-K/ha", "⚖️"),
    Module("m7", "Corrección\nP, K, S, B, Zn", "según análisis", "📊"),
    Module("m8", "Encalado\n(calcáreo)", "t/ha · PRNT", "⛰️"),
    Module("m9", "Aplicación\nde Yeso", "kg/ha · Ca-S", "🧂"),
    Module("m10", "Ficha de\nManejo del Lote", "bitácora", "📋"),
    Module("m11", "Regulación de\nPulverizadora", "L/ha · pastillas", "🚜"),
    Module("m12", "Conversión\nde Unidades", "qq · kg · ha", "🔄"),
    Module("m13", "Estimación de\nRinde — Soja", "qq/ha", "🌿"),
    Module("m14", "Estimación de\nRinde — Maíz", "qq/ha", "🌽")
)

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFff4f7f6))
    ) {
        // Header
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            color = Color(0xFF0f172a),
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "🌱 Criterio Agronómicos - Planilla 2026",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }

        // Grid de módulos
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(modules) { module ->
                ModuleButton(
                    module = module,
                    onClick = {
                        navController.navigate("module/${module.id}/${module.title}")
                    }
                )
            }
        }
    }
}

@Composable
fun ModuleButton(
    module: Module,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clickable(onClick = onClick),
        color = Color.White,
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = module.emoji,
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = module.title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0f172a),
                textAlign = TextAlign.Center,
                lineHeight = 14.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = module.subtitle,
                fontSize = 9.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF94a3b8),
                textAlign = TextAlign.Center
            )
        }
    }
}
