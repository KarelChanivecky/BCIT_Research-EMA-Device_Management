package ca.bcit_research.ema.MenuFSM.menus;


import ca.bcit_research.ema.MenuFSM.menus.BaseMenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.Option;

/**
 * Used to test functionality of MenuProvider FSM.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class MockStringMenu extends BaseMenuProvider {

    public MockStringMenu(String name, String... optionNames) throws IllegalArgumentException {
        super(name);
        for (String optionName: optionNames) {
            options.add(new Option(optionName, () -> this));
        }
    }

}
