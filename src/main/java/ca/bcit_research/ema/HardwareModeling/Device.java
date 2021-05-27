package ca.bcit_research.ema.HardwareModeling;

import java.util.List;

/**
 * An interface to interact with the physical properties of a device.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface Device extends WithMetrics, WithOtherProperties {

    /**
     * Gets a list of inputs available in the device
     */
    List<BoardInput> getInputs();

    /**
     * Get a list of sensors plugged in to the device.
     * @return a List of sensors
     */
    List<Sensor> getSensors();

    /**
     * Get the CommModule of the device.
     */
    CommModule getCommModule();

    /**
     * Sets the CommModule of the device.
     * @param newCommModule a new CommModule. May not be null.
     * @return true if the newCommModule was applied
     */
    boolean setCommModule(CommModule newCommModule);

    /**
     * Unplug all sensors from inputs.
     */
    void resetInputs();

    /**
     * Exchange a sensor for another.
     * @param sensor the interface type of the new sensor must match the one of the old sensor
     * @param pathToSensor the path to the input
     * @return
     */
    boolean setSensor(Sensor sensor, String pathToSensor);
}
