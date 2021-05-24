package ca.bcit_research.ema.MenuFSM.Model;

import ca.bcit_research.ema.HardwareModeling.Device;

/**
 * A DeviceMenu is a menu that acts on the virtual model of a Device.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public abstract class DeviceMenuProvider extends BaseMenuProvider {
    private final Device device;

    public DeviceMenuProvider(String name, Device device) throws IllegalArgumentException {
        super(name);
        this.device = device;
    }

}
