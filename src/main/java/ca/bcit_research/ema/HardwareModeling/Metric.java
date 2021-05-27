package ca.bcit_research.ema.HardwareModeling;

/**
 * Models one of the metrics to be measured by a sensor.
 *
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class Metric implements KeyValue<String, Boolean> {
    private final String name;
    private final String readingFormat;
    private boolean armed = false;

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
    public Boolean getValue() {
        return armed;
    }

    @Override
    public boolean setValue(Boolean armed) {
        this.armed = armed;
        return armed;
    }

    /**
     * Toggle the metric between armed and not armed.
     * @return The value after toggling
     */
    public boolean toggle() {
        armed = !armed;
        return armed;
    }

    public String getName() {
        return name;
    }

    public String getReadingFormat() {
        return readingFormat;
    }
}
