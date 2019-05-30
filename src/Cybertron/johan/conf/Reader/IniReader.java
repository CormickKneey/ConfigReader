package Cybertron.johan.conf.Reader;

import Cybertron.johan.conf.ConfigInterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Johan
 * Read the ini files
 */
public class IniReader extends ConfigParser {

    @Override
    public ConfigInterface read(String ini_file) {

        Properties props = new Properties();
        InputStream in = null;
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(ini_file);
            if (in != null) {
                props.load(in);
            }
            // 解析ini文件
            for (Object s : props.keySet()) {
                configMap.put(s.toString(), props.getProperty(s.toString()));
            }

        } catch (IOException e) {
            System.out.println("load ini file error!");
            System.out.println(e);
        }
        return this;
    }

}