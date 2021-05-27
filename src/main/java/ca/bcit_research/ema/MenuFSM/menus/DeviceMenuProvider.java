package ca.bcit_research.ema.MenuFSM.menus;

import ca.bcit_research.ema.HardwareModeling.VirtualDevice;

/**
 * A DeviceMenu is a menu that acts on the virtual model of a Device.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public abstract class DeviceMenuProvider extends BaseMenuProvider {
    private final VirtualDevice device;

    public DeviceMenuProvider(String name, VirtualDevice device) throws IllegalArgumentException {
        super(name);
        this.device = device;
    }

}
