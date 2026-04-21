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

**⚠️ Guarda `release.keystore` en un lugar seguro (NO lo subas al repositorio). Si lo pierdes, no podrás publicar actualizaciones firmadas con la misma identidad.**

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

En el próximo push a `master`, el workflow publicará en el release `latest` uno de estos archivos:

- `SamsungTVRemote-release.apk` cuando los secrets de firma estén configurados.
- `SamsungTVRemote-release-unsigned.apk` como fallback cuando no haya secrets de firma.

En pull requests hacia `master` también se ejecuta el build y se suben artifacts del APK, pero no se publica el release `latest` hasta que se haga push a `master`.

Si haces un push de un tag `v*` (por ejemplo `v1.0.0`), el workflow publica un release versionado con el APK generado.
