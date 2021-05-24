package ca.bcit_research.ema.MenuFSM;


/**
 * An ActionMenu is a menu that provides actions that do not depend on other state of the application.
 *
 * Extend this class if you want a Menu provider with hardcoded behaviour
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class ActionMenu extends BaseMenu {

    public ActionMenu(String name) throws IllegalArgumentException {
        super(name);
    }

}
