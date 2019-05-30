package Cybertron.johan.conf.Reader;

import Cybertron.johan.conf.ConfigInterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Johan
 * Read the properties files
 */
public class PropertiesReader extends ConfigParser {

    @Override
    public ConfigInterface read(String prop_file) {

        Properties props = new Properties();
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(prop_file);
            if (in != null) {
                props.load(in);
            }
            // 解析properties文件
            Set<Map.Entry<Object, Object>> set = props.entrySet();
            Iterator<Map.Entry<Object, Object>> it = set.iterator();
            while (it.hasNext()) {
                Map.Entry<Object, Object> entry = it.next();
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                String fuKey = getFukey(value);
                if(null != fuKey && null != props.get(fuKey)){
                    String fuValue = props.get(fuKey).toString();
                    value = value.replaceAll("\\$\\{" + fuKey + "\\}", fuValue);
                }
                configMap.put(key, value);
            }
        } catch (IOException e) {
            System.out.println("load properties file error!");
            System.out.println(e);
        }
        return this;
    }

    private String getFukey(String str){
        if(null != str && str.indexOf("${") != -1){
            int start = str.indexOf("${");
            int end = str.indexOf("}");
            if(start != -1 && end != -1){
                return str.substring(start + 2, end);
            }
        }
        return null;
    }

}
