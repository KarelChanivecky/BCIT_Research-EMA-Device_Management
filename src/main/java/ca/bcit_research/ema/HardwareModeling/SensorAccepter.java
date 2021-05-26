package ca.bcit_research.ema.HardwareModeling;

import java.util.ArrayList;

/**
 * Interface for classes that contain inputs that accept sensors.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface SensorAccepter {

    public ArrayList<Sensor> getSensors();

    public ArrayList<BoardInput> getInputs();
}
