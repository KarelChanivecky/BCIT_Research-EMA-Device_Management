package ca.bcit_research.ema.MenuFSM;

/**
 *  An Option represents a possible choice in a menu.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class Option {
    private int position;
    private final String name;
    private final OptionAction action;

    /**
     *  Build instance of option
     *
     * @param position The position this option will take in the menu. Must be larger than 0
     * @param name The name of the option
     * @param action The action to be done by the option when selected
     */
    public Option(int position, String name, OptionAction action) {
        if (position < 1) {
            throw new IllegalArgumentException("Position must be at least 1");
        }
        this.position = position;

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must be at least 1 character long");
        }
        this.name = name;

        if (action == null) {
            throw new IllegalArgumentException("Action must not be null");
        }
        this.action = action;
    }

    public void setPosition(int newPosition) {
        if (newPosition < 1) {
            throw new IllegalArgumentException("Position must be at least 1");
        }
        this.position = newPosition;
    }

    /**
     * Selects the choice and runs the action it represents.
     *
     * May cause side effects
     *
     * @return The next menu that should be provided
     * @throws Exception Any exception may be thrown
     */
    public MenuProvider select() throws Exception {
        return action.run();
    }
}
