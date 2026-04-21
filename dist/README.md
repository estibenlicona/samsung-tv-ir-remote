# Distribución de APK

Los APKs se publican automáticamente desde GitHub Actions en cada push a `master`.

## Descarga recomendada

- Release `latest`: https://github.com/estibenlicona/samsung-tv-ir-remote/releases/latest

## Archivos esperados

| Archivo | Cuándo aparece |
|---|---|
| `SamsungTVRemote-release.apk` | Cuando los secrets de firma están configurados y el APK release se firma automáticamente |
| `SamsungTVRemote-release-unsigned.apk` | Fallback cuando no hay secrets de firma configurados |

Si necesitas configurar la firma automática en este repo (o en un fork), sigue la guía en [`docs/SIGNING.md`](../docs/SIGNING.md).
