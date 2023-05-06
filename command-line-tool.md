# Command-line tool

<br>

The GRIFFIN command-line tool is designed to allow you to:
<ul>
	<li>Extract resource for its further manipulation in the scripts</li>
	<li>Verifying container integrity and digital signature</li>
	<li>Get container metadata</li>
	<li>Get list of container resources</li>
</ul>

<br>

```text
GRIFFIN command-line tool                                                       
                                                                                
Usage:                                                                          
      node griffin.js <container file> [OPTIONS] [FLAGS] [COMMANDS]             
                                                                                
OPTIONS:                                                                        
-q, --query <id,…>             Comma-separated list of resources IDs            
-u, --user <username>          User profile                                     
-p, --password <password>      User password                                    
-a, --attributes <{key:val,…}> User attributes JSON object                      
-t, --instCode <code>          Installation code                                
-r, --regCode <code>           Registration code                                
-s, --resPassword <password>   Resource password                                
-x, --xorMask <mask>           Resource XOR mask                                
                                                                                
FLAGS:                                                                          
-n, --no-color                 Disable ANSI color output for --print-… commands 
                               Has the same effect as NO_COLOR environment var. 
                                                                                
COMMANDS:                                                                       
-h, --help                     Display this help and exit                       
-v, --version                  Display the tool version and exit                
-f, --verify                   Verify container digest and signature            
-i, --print-info               Print container metadata to stdout as json       
-l, --print-list               Print list of resources to stdout as json        
```

<br>

## Examples:

### Extract resource:

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

<br>

### Get container metadata:

Command line:
```console
$ node griffin.js extract-resource-with-cli-tool.html --print-info
```

<br>

Output:
```javascript
{
  title: 'extract-resource-with-cli-tool',
  description: 'No description provided',
  docDigest: 'a8b965ece8a59260684eeb9dd0381ea7ebeea46c164b3ba77e1d2aee457a5bd4',
  publicKey: 'MIGbMBAGByqGSM49AgEGBSuBBAAjA4GGAAQAGty9g/SHr4QsplofCKkyBopWiIuuAXkbQqbMVJrVCbZ9vXAreSVia0hbk0ksQvh0Jdf7p8OsMvfX6CRMPvGiS9EAecA+ZSNubhjsFBiNx59ia1EZzfmJ8T9O0isCN0cjQdUVWPEm2Dc8jCsC+pGWmlJr0YgHSp33OUlK/L+Wz7PTwHY=',
  publicKeyFormat: 'spki',
  algName: 'ECDSA',
  algEcNamedCurve: 'P-521',
  algRsaModulusLength: 'null',
  algRsaHash: 'null',
  signatureHashAlg: 'SHA-512',
  signature: 'AS6vpO+n2j9gVDFliPePoOYkodnC7kqomSr12NTxCKW30VynpsAONbblI2pjQLGgPHqWmPU8TsnOnInJoAga6xv7Abbk3mdiPTg0FgRBE1lx+4hyUE6YVZ2J179XN3m805HH2R5s2FzVMJDqZowVsBoomDPvwJHJh80OmUtzhNJB7mt5',
  uuid: '3fa17dbd-18ef-4808-861c-67b5ed452175'
}
```

Source: <a href="https://github.com/griffin-container/griffin-container.github.io/blob/main/examples/xml/extract-resource-with-cli-tool.xml">extract-resource-with-cli-tool.xml</a>

<br>

### List resources:

Command line:
```console
$ node griffin.js resource-types.html --print-list
```

<br>

Output:
```javascript
{
  '000IX': {
    title: 'Plain text',
    description: "Address of Sherlock Holmes' house"
  },
  '03K01': { title: 'HTML', description: "Alice's Adventures in Wonderland" },
  '0069N': { title: 'Link', description: 'Link resource example' },
  '0019F': { title: 'Data-URI', description: 'Lewis Carroll photo' },
  '00030': { title: 'Data-URI (audio)', description: 'Lewis Carroll photo' },
  '000LW': { title: 'Data-URI (video)', description: 'Lewis Carroll photo' },
  '01R8L': { title: 'TOTP', description: 'Alice TOTP at example.com' },
  '03L81': {
    title: 'Container source',
    description: "Source of this container (type='self')"
  }
}
```

Source: <a href="https://github.com/griffin-container/griffin-container.github.io/blob/main/examples/xml/resource-types.xml">resource-types.xml</a>

<br><br>
