package ca.bcit_research.ema.HardwareModeling;


import java.util.ArrayList;
import java.util.List;

/**
 * Models an end-device.
 *
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class VirtualDevice implements Device {

    private DeviceBoard board;
    private String name;
    ArrayList<OtherProperty> properties = new ArrayList<OtherProperty>();

    public VirtualDevice(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("The name must be at least 1 character long");
        }
        this.name = name;
        board = null;
    }

    /**
     * Set the given board as the new board.
     *
     * This will result in resetting the state of all members of board
     * @param newBoard a new DeviceBoard. May not be null
     */
    public void setBoard(DeviceBoard newBoard) {
        this.board = newBoard;
    }

    @Override
    public List<Sensor> getSensors() {
        return board.getSensors();
    }

    @Override
    public CommModule getCommModule() {
        return board.getCommModule();
    }

    @Override
    public boolean setCommModule(CommModule newCommModule) {
        return board.setCommModule(newCommModule);
    }

    @Override
    public void resetInputs() {
        board.resetInputs();
    }

    @Override
    public boolean setSensor(Sensor sensor, String pathToSensor) {
        return board.setSensor(sensor, pathToSensor);
    }

    @Override
    public List<BoardInput> getInputs() {
        return board.getInputs();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toYaml() {
        return null;
    }

    @Override
    public List<Metric> getMetrics() {
        return board.getMetrics();
    }

    /**
     * Add a new property to virtual device.
     *
     * The new property will be applied to the array that the virtual device maintains itself
     * @param otherProperty the new property to add
     * @return true if added
     */
    @Override
    public boolean addOtherProperty(OtherProperty otherProperty) {
        return properties.add(otherProperty);
    }

    @Override
    public List<OtherProperty> getProperties() {
        ArrayList<OtherProperty> propertiesToExpose = new ArrayList<>(properties);
        propertiesToExpose.addAll(board.getProperties());
        return propertiesToExpose;
    }


    // Can't decide if I want to try to remove the property everywhere
    @Override
    public boolean removeProperty(OtherProperty otherProperty) {
        return false; // TODO
    }

    // cant decide if I want to swap the property everywhere
    @Override
    public boolean swapProperties(OtherProperty newProperty, OtherProperty oldProperty) {
        return false; // TODO
    }
}
