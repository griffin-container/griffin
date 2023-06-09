# Usage Examples

<br>

Some examples require pre-generated:
- random cryptographic materials
- key pairs for electronic signatures
- shared secrets

To simplify the generation of the above stuff, you can use the built-in tools (a kind of Swiss Army Knife):<br>
<a href="https://github.com/griffin-container/griffin/blob/main/browser-console-tools.md">GRIFFIN Browser Console Tools (GBCT)</a>

<br>

## Hello, World!
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/hello-world.xml">hello-world.xml</a>

## Public, private and shared resources
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/public-private-shared-resources.xml">public-private-shared-resources.xml</a>

## Extra resource protection with a resource password and(or) XOR mask

<b>Tip:</b><br>
Use the <a href="https://github.com/griffin-container/griffin/blob/main/browser-console-tools.md">GRIFFIN Browser Console Tools (GBCT)</a> to generate random cryptographic materials.

Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/protected-resources.xml">protected-resources.xml</a>

## Protect your container by pairing it with a specific device
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/installation-and-registration.xml">installation-and-registration.xml</a>

## Set session expiration time
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/session-expiration-settings.xml">session-expiration-settings.xml</a>

## Use a pre-created shared secrets instead a passwords

<b>Tip:</b><br>
Use the <a href="https://github.com/griffin-container/griffin/blob/main/browser-console-tools.md">GRIFFIN Browser Console Tools (GBCT)</a> to generate compatible shared secrets.

Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/shared-secret.xml">shared-secret.xml</a>

## Protect your container with a digital signature

<b>Tip:</b><br>
Use the <a href="https://github.com/griffin-container/griffin/blob/main/browser-console-tools.md">GRIFFIN Browser Console Tools (GBCT)</a> to generate compatible digital signature section.

Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/signed-container.xml">signed-container.xml</a>

## Additional protection with user attributes
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/user-attributes.xml">user-attributes.xml</a>

## Display resources by resource ID

Display only resource with <code>id=MY1</code>:
```text
https://example.com/resource-id.html#MY1
```

<br>

Display only resources with <code>id=00024</code> and <code>id=MY2</code>:
```text
https://example.com/resource-id.html#00024,MY2
```
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/resource-id.xml">resource-id.xml</a>

## Lock your profile in case of a container leak<br>(Requires a REST endpoint that provides a remote access code)
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/lock-user-profile.xml">lock-user-profile.xml</a>

## Lock user profiles remotely<br>(Requires a REST endpoint that provides a remote access code)
Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/remote-code.xml">remote-code.xml</a>

## Extract resource with command-line tool

Go to menu (top-left corner) and choose:<br>
<b>Download command-line tool</b><br><br>
The <a href="https://github.com/griffin-container/griffin/blob/main/command-line-tool.md">GRIFFIN command-line tool</a> is built-in into every container and can be downloaded offline.
<br><br>
Command line:
```console
$ node griffin.js extract-resource-with-cli-tool.html -u alice -p rabbit -q AL123
```

<br>

Output:
```text
p@$$word
```

Source: <a href="https://github.com/griffin-container/griffin/blob/main/examples/xml/extract-resource-with-cli-tool.xml">extract-resource-with-cli-tool.xml</a>

See more:<br>
<a href="https://github.com/griffin-container/griffin/blob/main/command-line-tool.md">GRIFFIN command-line tool</a>
