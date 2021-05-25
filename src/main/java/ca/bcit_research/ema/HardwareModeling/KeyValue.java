package ca.bcit_research.ema.HardwareModeling;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface KeyValue<T,E> {
    T getKey();
    E getValue();
    boolean setValue(E newValue);
    String toString();
}
