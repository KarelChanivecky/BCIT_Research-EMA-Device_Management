package ca.bcit_research.ema.MenuFSM;

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
     * Select and run an option.
     *
     * @param option the chosen option
     * @return The next MenuProvider to present
     */
    MenuProvider select(Option option);

    /**
     * Presents this MenuProvider as an Option.
     *
     * @param position The position that this option will take
     * @return An Option to navigate into this MenuProvider
     */
    Option toOption(int position);
}
