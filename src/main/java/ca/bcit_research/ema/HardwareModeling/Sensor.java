package ca.bcit_research.ema.HardwareModeling;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a sensor.
 *
 * The possible sensors are identified by config files in the end device repo of the EMA project.
 * Every implemented sensor driver must also have a config file.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class Sensor implements WithMetrics, WithPhysicalInterface {
    private final String manufacturer;
    private final String model;
    private final PhysicalInterface interfaceType;
    private final ArrayList<Metric> metrics;

    public Sensor(String manufacturer, String model, PhysicalInterface interfaceType, ArrayList<Metric> metrics) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.interfaceType = interfaceType;
        this.metrics = metrics;
    }

    /**
     * Provided so class can be instantiated with information from config file.
     * @param pathToConfig the path to the configuration file
     */
    public Sensor(String pathToConfig) {
        //TODO
        manufacturer = null;
        model = null;
        interfaceType = null;
        metrics = null;
    }

    @Override
    public List<Metric> getMetrics() {
        return metrics;
    }

    @Override
    public PhysicalInterface getInterface() {
        return interfaceType;
    }
}
