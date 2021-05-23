package ca.bcit_research.ema.MenuFSM;

import java.util.ArrayList;


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
     * @return A list of options with implementation-defined order
     */
    ArrayList<Option> getOptions();

    /**
     * Choose an option.
     *
     * Choosing an option
     *
     * @param option The option to choose
     * @throws Exception May throw any exception
     * @return The next MenuProvider that should be displayed
     */
    MenuProvider choose(Option option) throws Exception;

}
