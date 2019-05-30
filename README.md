# ConfigReader
Java tools to read config files in .ini and .properties

## Usage
```java
import Cybertron.johan.conf.ConfigInterface;
import Cybertron.johan.conf.Reader.Loader;
```


```java
        ConfigInterface conf = Loader.load("conf.properties(or .ini)");
        String key = conf.getString("key");
        // Support Integer , Long , Boolean , Double
        System.out.println(key);
```


## .ini
[section]
key=value
; annotation

## .properties
key=value
key.child=value
