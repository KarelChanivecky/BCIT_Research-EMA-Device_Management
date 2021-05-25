package ca.bcit_research.ema.MenuFSM.Model;

import java.util.ArrayList;
import java.util.List;


/**
 * A MenuSerializer takes in a variable number of MenuProviders, and presents them as one.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface MenuSerializer {

    /**
     * Get the options contained in all of the given MenuProviders.
     *
     * @param menuProviders A list of menu providers
     * @param otherMenus Additional menus to process
     * @return A list of options with implementation-defined order
     */
    ArrayList<Option> getOptions(List<MenuProvider> menuProviders, MenuProvider...otherMenus);
}
