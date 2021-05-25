package ca.bcit_research.ema.HardwareModeling;

/**
 * This class models a Key value pair of configurations.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class OtherConfig implements KeyValue<String, String>{
        String name;
        String value;

    public OtherConfig(String name, String value) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Metric name must be at least 1 character long");
        }
        this.name = name;
        this.value = value;
    }

    @Override
    public String getKey() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean setValue(String newValue) {
        value = newValue;
        return true;
    }
}
