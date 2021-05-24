package ca.bcit_research.ema.MenuFSM;

import ca.bcit_research.ema.HardwareModeling.Device;

/**
 * A DeviceMenu is a menu that acts on the virtual model of a Device.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public abstract class DeviceMenu extends NavigationMenu {
    private final Device device;

    public DeviceMenu(String name, Device device, MenuProvider parentMenu) throws IllegalArgumentException {
        super(name, parentMenu);
        this.device = device;
    }

}
