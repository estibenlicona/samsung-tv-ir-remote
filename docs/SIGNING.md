# Firma automática del APK release

## 1. Generar un keystore (solo la primera vez)

```bash
keytool -genkey -v \
  -keystore release.keystore \
  -alias samsung-tv-remote \
  -keyalg RSA -keysize 2048 -validity 10000
```

Te pedirá:
- Contraseña del keystore (guárdala — será `SIGNING_STORE_PASSWORD`).
- Datos del certificado (nombre, org, ciudad, etc.).
- Contraseña de la clave (puede ser la misma — será `SIGNING_KEY_PASSWORD`).

**⚠️ Guarda `release.keystore` en un lugar seguro (NO lo commitees). Si lo pierdes, no podrás publicar updates firmados con la misma identidad.**

## 2. Convertir el keystore a base64

```bash
base64 -w 0 release.keystore > release.keystore.b64
cat release.keystore.b64    # copia este contenido
```

En macOS sin `-w`:

```bash
base64 -i release.keystore | tr -d '\n' > release.keystore.b64
```

## 3. Configurar los GitHub Secrets

Ve a **Settings → Secrets and variables → Actions → New repository secret** y crea:

| Secret | Valor |
|---|---|
| `SIGNING_STORE_BASE64` | contenido de `release.keystore.b64` |
| `SIGNING_STORE_PASSWORD` | contraseña del keystore |
| `SIGNING_KEY_ALIAS` | `samsung-tv-remote` (el alias que usaste) |
| `SIGNING_KEY_PASSWORD` | contraseña de la clave |

## 4. Listo

En el próximo push a `master` el workflow firmará el APK automáticamente y lo publicará como `SamsungTVRemote-release.apk` en el release `latest`. Si los secrets no están configurados, el workflow seguirá funcionando y publicará la versión sin firmar como fallback.
