package ca.bcit_research.ema.HardwareModeling;

import java.util.List;

/**
 * Models a board input.
 *
 * A board input is by default created with no Sensor.
 *  Sensors plug into the boardInput
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class BoardInput implements KeyValue<String, Sensor>, WithMetrics, WithPhysicalInterface {
    private final PhysicalInterface interfaceType;
    private Sensor sensor;
    private final String path;

    public BoardInput(PhysicalInterface interfaceType, String path) {
        this.interfaceType = interfaceType;
        this.path = path;
    }

    @Override
    public String getKey() {
        return path;
    }

    @Override
    public Sensor getValue() {
        return sensor;
    }

    @Override
    public boolean setValue(Sensor newSensor) {
        if (sensor.getInterface() == newSensor.getInterface()) {
            sensor = newSensor;
            return true;
        }
        return false;
    }

    @Override
    public List<Metric> getMetrics() {
        return sensor.getMetrics();
    }

    @Override
    public PhysicalInterface getInterface() {
        return interfaceType;
    }

    public boolean plugSensor(Sensor sensor) {
        return setValue(sensor);
    }

    public void unplugSensor() {
        sensor = null;
    }

    /**
     * The path represents the hardware identifier for the input.
     *
     * For example, in Linux inputs would have such a path:
     * /dev/com1
     *
     * @return the path to the sensor
     */
    public String getPath() {
        return path;
    }
}
