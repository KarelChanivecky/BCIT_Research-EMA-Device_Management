package ca.bcit_research.ema.MenuFSM.Model;

/**
 * Models the UI layer.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface MenuUI {

    /**
     * Starts up the UI.
     *
     * @param rootMenu The root of the FSM tree.
     * @param otherMenus Provided in case you want some options to always be available
     */
    void displayMenu(MenuProvider rootMenu, MenuProvider...otherMenus);

}
