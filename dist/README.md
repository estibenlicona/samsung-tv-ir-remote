# Descarga del APK

Los APKs compilados **no se almacenan en el repositorio** (es mala práctica commitear binarios).
En su lugar, se generan automáticamente por GitHub Actions en cada push a `master`.

## 📥 Descargar la última versión

### Opción 1: Desde Releases (recomendado)
Ve a [Releases](https://github.com/estibenlicona/samsung-tv-ir-remote/releases) y descarga:
- `SamsungTVRemote-debug.apk` — listo para instalar en tu celular.
- `SamsungTVRemote-release-unsigned.apk` — requiere firmar antes de instalar (solo para distribución formal).

El tag `latest` siempre apunta al último build exitoso de `master`.

### Opción 2: Desde Actions artifacts
1. Ve a la pestaña [Actions](https://github.com/estibenlicona/samsung-tv-ir-remote/actions).
2. Abre el último workflow "Build APK" exitoso.
3. Descarga el artifact `apk-builds` (zip con ambos APKs). Requiere estar autenticado en GitHub.

## 📱 Instalación

1. Copia el `.apk` a tu celular con IR blaster.
2. Habilita "Instalar apps de orígenes desconocidos" en Ajustes → Seguridad.
3. Abre el archivo con un explorador de archivos y sigue el asistente.

## ⚠️ Recuerda

La app solo funcionará en celulares con **emisor infrarrojo físico** (ej. Galaxy S4/S5/S6, Xiaomi Mi Max, Redmi Note 4, Huawei Mate antiguos). En celulares sin IR blaster, la app abrirá pero mostrará un aviso y los botones estarán deshabilitados.
