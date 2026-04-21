# samsung-tv-ir-remote

[![Build APK](https://github.com/estibenlicona/samsung-tv-ir-remote/actions/workflows/build-apk.yml/badge.svg)](https://github.com/estibenlicona/samsung-tv-ir-remote/actions/workflows/build-apk.yml)

## 📥 Descarga del APK

- **Última versión estable:** [Releases](https://github.com/estibenlicona/samsung-tv-ir-remote/releases/latest)
- **Builds de cada commit:** [Actions artifacts](https://github.com/estibenlicona/samsung-tv-ir-remote/actions)

Más detalles en [`dist/README.md`](./dist/README.md).
# Samsung TV IR Remote (Android)

Aplicación Android nativa en Kotlin para controlar TVs Samsung mediante el emisor infrarrojo (IR blaster) del teléfono usando `ConsumerIrManager`.

## Requisitos

- Android Studio Hedgehog o superior.
- SDK Android 34.
- Celular Android con emisor IR físico integrado.

Ejemplos de dispositivos con IR (según modelo/región):
- Samsung Galaxy S4 / S5 / S6
- Xiaomi Mi Max
- Redmi Note 4
- Algunos Huawei Mate antiguos

## Cómo compilar

### Opción 1: Android Studio
1. Abre este proyecto en Android Studio.
2. Espera la sincronización de Gradle.
3. Ejecuta la configuración `app` en un dispositivo físico con IR.

### Opción 2: Línea de comandos
```bash
./gradlew assembleDebug
```

## Nota sobre Gradle Wrapper

Este repositorio incluye `gradle/wrapper/gradle-wrapper.properties`, pero no incluye binarios del wrapper.

Si no tienes `gradlew` generado localmente, ejecuta:

```bash
gradle wrapper --gradle-version 8.4
```

## Cómo instalar el APK

Después de compilar, instala:

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Advertencia importante

Si el celular no tiene emisor IR, la app lo detecta y muestra un aviso en pantalla. En ese caso, los botones del control se muestran deshabilitados.

## Licencia

MIT (recomendado para este proyecto).
