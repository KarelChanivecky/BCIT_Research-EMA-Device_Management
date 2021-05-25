package ca.bcit_research.ema.HardwareModeling;

/**
 * Models one of the metrics to be measured by a sensor.
 *
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class Metric implements KeyValue<String, Integer> {
    String name;
    int bytesPerReading;

    public Metric(String name, int bytesPerReading) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Metric name must be at least 1 character long");
        }

        if (bytesPerReading < 0) {
            throw new IllegalArgumentException("bytesPerReading may not be negative");
        }
        this.name = name;
        this.bytesPerReading = bytesPerReading;
    }

    @Override
    public String getKey() {
        return name;
    }

    @Override
    public Integer getValue() {
        return bytesPerReading;
    }

    @Override
    public boolean setValue(Integer newBytesPerReading) {
        if (newBytesPerReading < 0) {
            throw new IllegalArgumentException("newBytesPerReading may not be negative");
        }

        bytesPerReading = newBytesPerReading;
        return true;
    }
}
