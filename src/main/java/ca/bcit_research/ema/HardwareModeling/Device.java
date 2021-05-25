package ca.bcit_research.ema.HardwareModeling;

import ca.bcit_research.ema.MenuFSM.Model.MenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.NavigationMenuProvider;

/**
 * Models an end-device.
 *
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class Device {

    private DeviceBoard board;
    private String name;

    public Device(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("The name must be at least 1 character long");
        }
        this.name = name;
        board = null;
    }


    private void setBoard(DeviceBoard newBoard) {
        this.board = newBoard;
    }

    public String toYaml() {
        return null;
    }

    public NavigationMenuProvider getOtherConfigsMenu() {
        return null;
    }

    public MenuProvider setBoardMenu() {
        return null;
    }

    public NavigationMenuProvider getSensorMenu() {
        return null;
    }

    public NavigationMenuProvider getInputsMenu() {
        return null;
    }



}
