# GRIFFIN Browser Console Tools (GBCT)

<br>

The GRIFFIN Browser Console Tools (GBCT) help you to generate compatible cryptographic materials, key pairs for electronic signatures and shared secrets.<br>
To access GBCT, use the <b>F12</b> key to open DevTools console in your browser.
<br><br>

## Generate random string

<br>
Browser console:

```javascript
Tools.genRandomString(320)

// 320 - length of generated string
```

<br>
Output:

```text
KM9EFqJCwiETQeQNXFulUCiawJPp9krc4jr6wA8NutdtTVb5PlWs8LvhQWEoV0mP
Nwga277XseAKx4obJIrVRcsdj1Z04Zq95Wn0vVP32Wue0ndycBkVfDXwXjp6lkcY
LYGXtOtadWyxzDBNmCWhnrImdaTF3q3IUhM6h83IYtD7CpHskzRxpt6SkRPOynOW
styAfmXItowDVVr0II8aIMeNAoxENYRsBHhivB0C9ljcqkUn1x6Ze5fslV43Q9tZ
fh1QY7Emo6gXdnhj0NgvaTQBtwRWYqmakVjDfWpm2vrY0YawjZpqgISQ0ufms4i5
```

<br>

## Split long string into chunks

<br>
Browser console:

```javascript
Tools.chuncString("ZW9yYQ0AAABMYXZmNTcuMjYuMTAwAQBbmNvZGVyPUxhdmM1Ny4yNC4xMDUgbGlidGhlb3JhgnW9", 64)

// "ZW9yYQ0AAABMYXZmNTcuMjYuMTAwAQBbmNvZGVyPUxhdmM1Ny4yNC4xMDUgbGlidGhlb3JhgnW9" - source string
// 64                                                                            - length of generated chunks
```

<br>
Output:

```text
ZW9yYQ0AAABMYXZmNTcuMjYuMTAwAQBbmNvZGVyPUxhdmM1Ny4yNC4xMDUgbGlid
Ghlb3JhgnW9
```

<br>

## Generate shared secret

<br>
Browser console:

```javascript
Tools.genSharedSecret('p@$$word', 5, 2)

// 'p@$$word' - password
//          5 - number of shares
//          2 - quorum
```

<br>
Output:

```text
801e85b886e91679d6b6bbc75ed1ca7916ef5d1f4857c41c13da44c2a6703983548,
802cdb60ddc3fce27d6d665eac738533fdff713f581f8339fe355f454a206ed6a00,
80325ed85b2aea9babdbdd99f2a24f4aeb002a60176841d5ea9f19c7ee105355f38,
80487711aa57e814eb1b1cac99370a67ea0f38af789edd72342aa99a8350c07d490,
8056f2a92cbefe6d3dada76bc7e6c01efcf063f037e91f9e2080ef182760fdfe1a8
```

<br>

## Generate signature settings

<br>
Browser console:

```javascript
Tools.genSignatureSettings('SHA-512', 'P-521')

// 'SHA-512' - digest algorithm
// 'P-521'   - name of the elliptic curve
```

<br>
Output:

```xml
<signature hashAlg="SHA-512">
	<keyPair algName="ECDSA" algEcNamedCurve="P-521">
		<privateKey keyFormat="pkcs8">
MIHuAgEAMBAGByqGSM49AgEGBSuBBAAjBIHWMIHTAgEBBEIAdfiO8xdqh6g1WuJR
KiFpNdVQCfkYt4knfGhmroZzXJ7dsdorW5TYV6RixDw27YTYmRjhdo6OZiDSgCK2
HbTQDfyhgYkDgYYABADp+WhGAjl3eec19MM5tUHeA9zk9NBNN+C+MvIZfLZYCzCs
wuY/0NFBmiVEx9rrt2JyFurGA+9pMnLXZl8mq82zQQHd+PehZO+FwEgZIKElspGv
2XhqpcHfLFPNH3EDCC4OgQ1GVr2sXwTsbMTkuIl18FPTF2poBlUmiNdfHsttFW7w
bQ==
		</privateKey>
		<publicKey keyFormat="spki">
MIGbMBAGByqGSM49AgEGBSuBBAAjA4GGAAQA6floRgI5d3nnNfTDObVB3gPc5PTQ
TTfgvjLyGXy2WAswrMLmP9DRQZolRMfa67dichbqxgPvaTJy12ZfJqvNs0EB3fj3
oWTvhcBIGSChJbKRr9l4aqXB3yxTzR9xAwguDoENRla9rF8E7GzE5LiJdfBT0xdq
aAZVJojXXx7LbRVu8G0=
		</publicKey>
	</keyPair>
</signature>
```

<br>
<br>
