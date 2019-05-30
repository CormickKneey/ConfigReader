package Cybertron.johan.conf.Reader;

import Cybertron.johan.conf.ConfigInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Johan
 * Parse the file into the ConfigInterface
 */


public abstract class ConfigParser implements ConfigInterface {
    protected Map<String, Object> configMap = new HashMap<String, Object>();

    public String getString(String key) {
        Object object = configMap.get(key);
        if(null != object){
            return object.toString();
        }
        return null;
    }

    public Integer getInt(String key) {
        String value = this.getString(key);
        if(null != value){
            return Integer.parseInt(value);
        }
        return null;
    }

    public Long getLong(String key) {
        String value = this.getString(key);
        if(null != value){
            return Long.parseLong(value);
        }
        return null;
    }

    public Boolean getBoolean(String key) {
        String value = this.getString(key);
        if(null != value){
            return Boolean.parseBoolean(value);
        }
        return null;
    }

    public Double getDouble(String key) {
        String value = this.getString(key);
        if(null != value){
            return Double.parseDouble(value);
        }
        return null;
    }

    public <T> T get(Class<T> t) {
        try {
            @SuppressWarnings("unchecked")
            T tobj = (T) Proxy.newProxyInstance(t.getClassLoader(),
                    new Class[] { t }, new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                            String method_name = method.getName();
                            Class<?> returnClazz = method.getReturnType();

                            if(returnClazz == String.class){
                                return ConfigParser.this.getString(method_name);
                            }

                            if (returnClazz == Integer.class || returnClazz == int.class) {
                                return ConfigParser.this.getInt(method_name);
                            }

                            if(returnClazz == Long.class || returnClazz == long.class){
                                return ConfigParser.this.getLong(method_name);
                            }

                            if(returnClazz == Double.class || returnClazz == double.class){
                                return ConfigParser.this.getDouble(method_name);
                            }

                            if(returnClazz == Boolean.class || returnClazz == boolean.class){
                                return ConfigParser.this.getBoolean(method_name);
                            }

                            return null;
                        }
                    });
            return tobj;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract ConfigInterface read(String conf);
}
