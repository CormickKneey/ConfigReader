package Cybertron.johan.conf.Reader;

import Cybertron.johan.conf.ConfigInterface;
import Cybertron.johan.conf.Exception.LoadException;

/**
 * @author Johan
 */
public class Loader {
    public static ConfigInterface load(String conf){
        return load(conf, PropertiesReader.class);
    }

    public static ConfigInterface load(String conf, Class<? extends ConfigParser> adapter){

        if(null == conf || conf.equals("")){
            throw new LoadException("the config file name is null");
        }

        if(null == adapter){
            throw new LoadException("the config adapter class is null");
        }

        ConfigParser configAdapter = (ConfigParser) Ut.newInstance(adapter);
        return configAdapter.read(conf);
    }
}
