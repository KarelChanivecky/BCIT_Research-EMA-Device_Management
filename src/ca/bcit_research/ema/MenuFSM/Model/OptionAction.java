package ca.bcit_research.ema.MenuFSM.Model;

/**
 * The action to be called when an option is chosen
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public interface OptionAction {
    MenuProvider run();
}
