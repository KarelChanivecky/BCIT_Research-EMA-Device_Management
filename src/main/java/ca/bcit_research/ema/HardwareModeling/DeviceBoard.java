package ca.bcit_research.ema.HardwareModeling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Models a board.
 *
 * A board could be an arduino, RPI, etc. The information about the possible boards will be kept
 * in a resource dir. The resource dir will contain config files for each of the boards.
 * A config file, may or may not indicate which comm module to use
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class DeviceBoard implements Device {
    private final String manufacturer;
    private final String boardName;
    private CommModule commModule;
    private final ArrayList<BoardInput> boardInputs;

    public DeviceBoard(String manufacturer, String boardName, CommModule commModule, ArrayList<BoardInput> boardInputs) {
        this.manufacturer = manufacturer;
        this.boardName = boardName;
        this.commModule = commModule;
        this.boardInputs = boardInputs;
    }

    /**
     * This constructor is provided in case the comm module is not provided in the config file
     * @param pathToConfig The path where the config file can be found
     * @param commModule a comm module to add to this board
     */
    public DeviceBoard(String pathToConfig, CommModule commModule) {
        // TODO create board inputs by specs
        boardName = null;
        manufacturer = null;
        boardInputs = null;
    }

    /**
     * This constructor is provided in case the comm module info is included in the config file
     * @param pathToConfig The path where the config file can be found
     */
    public DeviceBoard(String pathToConfig) {
        // TODO create board inputs by specs
        boardName = null;
        manufacturer = null;
        boardInputs = null;
    }

    @Override
    public ArrayList<Sensor> getSensors() {
        ArrayList<Sensor> sensors = new ArrayList<>();
        boardInputs.forEach(boardInput -> sensors.add(boardInput.getValue()));
        return sensors;
    }

    @Override
    public CommModule getCommModule() {
        return commModule;
    }

    @Override
    public boolean setCommModule(CommModule newCommModule) {
        this.commModule = newCommModule;
        return true;
    }

    @Override
    public void resetInputs() {
        boardInputs.forEach(bi -> bi.setValue(null));
    }

    @Override
    public boolean setSensor(Sensor sensor, String pathToSensor) {
        AtomicBoolean set = new AtomicBoolean(false);
        boardInputs.forEach(bi -> {
            if (bi.getKey().equals(pathToSensor)) {
                bi.setValue(sensor);
                set.set(true);
            }
        });
        return false;
    }

    @Override
    public ArrayList<BoardInput> getInputs() {
        return boardInputs;
    }

    @Override
    public ArrayList<Metric> getMetrics() {
        ArrayList<Metric> metrics = new ArrayList<>();
        ArrayList<Sensor> sensors = getSensors();
        sensors.forEach(s -> metrics.addAll(s.getMetrics()));
        return metrics;
    }


    @Override
    public boolean addOtherProperty(OtherProperty otherProperty) {
        return commModule.addOtherProperty(otherProperty);
    }

    @Override
    public List<OtherProperty> getProperties() {
        return commModule.getProperties();
    }

    @Override
    public boolean removeProperty(OtherProperty otherProperty) {
        return commModule.removeProperty(otherProperty);
    }

    @Override
    public boolean swapProperties(OtherProperty newProperty, OtherProperty oldProperty) {
        return commModule.swapProperties(newProperty, oldProperty);
    }
}
