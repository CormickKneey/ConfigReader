package Cybertron.johan.conf;

/**
Interface to fetch the value
 @author Johan
 */




public interface ConfigInterface {
    /**
     *
     * @param key
     * @return string
     */
    String getString(String key);

    /**
     *
     * @param key
     * @return	into r null
     */
    Integer getInt(String key);

    /**
     *
     * @param key
     * @return	long or null
     */
    Long getLong(String key);

    /**
     *
     * @param key
     * @return	boolean or null
     */
    Boolean getBoolean(String key);

    /**
     *
     * @param key
     * @return	double or null
     */
    Double getDouble(String key);

    /**
     *
     * @param type	of the interface
     * @return	object
     */
    <T> T get(Class<T> type);
}
