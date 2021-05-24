package ca.bcit_research.ema.MenuFSM.Model;

import java.util.ArrayList;

/**
 * A MenuProvider is a source of menu options.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface MenuProvider {

    /**
     * Gets the options provided by this MenuProvider
     * @return a list of Option
     */
    ArrayList<Option> getOptions();

    /**
     * Presents this MenuProvider as an Option.
     *
     * @return An Option to navigate into this MenuProvider
     */
    Option toOption();
}
