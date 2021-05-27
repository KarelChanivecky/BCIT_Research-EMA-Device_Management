package ca.bcit_research.ema.HardwareModeling;

/**
 * Models one of the metrics to be measured by a sensor.
 *
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class Metric implements KeyValue<String, String> {
    String name;
    String readingFormat;
    boolean armed = false;

    public Metric(String name, String readingFormat) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Metric name must be at least 1 character long");
        }

        if (readingFormat == null) {
            throw new IllegalArgumentException("must provide reading format");
        }
        this.name = name;
        this.readingFormat = readingFormat;
    }

    public Metric(String name, String readingFormat, boolean armed) {
        this(name, readingFormat);
        this.armed = armed;
    }

    @Override
    public String getKey() {
        return name;
    }

    @Override
    public String getValue() {
        return readingFormat;
    }

    @Override
    public boolean setValue(String readingFormat) {
        if (readingFormat == null) {
            throw new IllegalArgumentException("must provide reading format");
        }
        this.readingFormat = readingFormat;
        return true;
    }

    /**
     * Toggle the metric between armed and not armed.
     * @return The value after toggling
     */
    public boolean toggle() {
        armed = !armed;
        return armed;
    }
}
