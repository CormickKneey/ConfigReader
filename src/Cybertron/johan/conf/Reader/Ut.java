package Cybertron.johan.conf.Reader;

/**
 * @author Johan
 */
public class Ut {
    public static Object createObject(Class<?> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> clazz){
        try {
            Object object = clazz.newInstance();
            return (T) object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
