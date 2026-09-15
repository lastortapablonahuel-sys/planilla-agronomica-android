# 🌱 Planilla Agronómica 2026 - Android App

Aplicación Android nativa en Kotlin para cálculos agronómicos y gestión de planillas de cultivo.

## 📋 Características

- **14 Módulos de Cálculo**: Siembra, fertilizantes, encalado, estimación de rindes, etc.
- **Interfaz Material Design 3**: Diseño moderno y responsivo
- **Jetpack Compose**: UI declarativa y eficiente
- **Cálculos en Tiempo Real**: Los resultados se actualizan mientras escribes
- **Soporte Multiidioma**: Interfaz en español
- **Diseño Optimizado para Móvil**: Adaptado para pantallas medianas y grandes

## 🛠️ Tecnologías

- **Kotlin** 1.9.20
- **Android API** 24 - 34
- **Jetpack Compose** (UI)
- **Material Design 3**
- **Navigation Compose**
- **Room Database** (para almacenamiento futuro)
- **MVVM Architecture**

## 📦 Módulos Disponibles

1. **M1** - Siembra de Granos
2. **M2** - Siembra de Forrajeras
3. **M3** - Engranajes de Sembradora
4. **M4** - Curado de Semilla
5. **M5** - Formulación de Fertilizantes
6. **M6** - Unidades de Fertilizante
7. **M7** - Corrección de Nutrientes
8. **M8** - Necesidad de Encalado
9. **M9** - Aplicación de Yeso
10. **M10** - Ficha de Manejo del Lote
11. **M11** - Regulación de Pulverizadora
12. **M12** - Conversión de Unidades
13. **M13** - Estimación de Rinde (Soja)
14. **M14** - Estimación de Rinde (Maíz)

## 🚀 Instalación y Ejecución

### Requisitos
- Android Studio Arctic Fox o superior
- JDK 1.8 o superior
- Gradle 8.2.0
- SDK Android 34

### Pasos

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/lastortapablonahuel-sys/planilla-agronomica-android.git
   cd planilla-agronomica-android
   ```

2. **Abrir en Android Studio**
   ```bash
   open -a "Android Studio" .
   ```

3. **Sincronizar Gradle**
   - File → Sync Now

4. **Ejecutar en dispositivo o emulador**
   - Click en ▶️ Run (Shift + F10)

## 📱 Compilar APK

### Debug APK
```bash
./gradlew assembleDebug
# APK generado en: app/build/outputs/apk/debug/
```

### Release APK
```bash
./gradlew assembleRelease
# APK generado en: app/build/outputs/apk/release/
```

## 🎨 Estructura del Proyecto

```
planilla-agronomica-android/
├── app/
│   ├── src/main/
│   │   ├── kotlin/com/agronomia/planilla/
│   │   │   ├── MainActivity.kt
│   │   │   ├── ui/
│   │   │   │   ├── theme/
│   │   │   │   ├── navigation/
│   │   │   │   └── screens/
│   │   ├── res/
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 🔄 Próximas Funcionalidades

- [ ] Implementar todos los 14 módulos de cálculo
- [ ] Base de datos Room para historial
- [ ] Exportar/Importar datos (CSV, PDF)
- [ ] Sincronización en la nube
- [ ] Modo offline
- [ ] Notificaciones
- [ ] Gráficos

## 📄 Licencia

MIT License

## 👨‍💻 Desarrollador

lastortapablonahuel-sys

---

**Versión**: 1.0.0 | **Septiembre 2026**
