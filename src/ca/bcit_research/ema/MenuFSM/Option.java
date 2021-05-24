package ca.bcit_research.ema.MenuFSM;

/**
 * An Option represents a possible choice in a menu.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public record Option(String name, OptionAction action) {

    /**
     * Build instance of option
     *
     * @param name   The name of the option
     * @param action The action to be done by the option when selected
     */
    public Option(String name, OptionAction action) {

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must be at least 1 character long");
        }
        this.name = name;

        if (action == null) {
            throw new IllegalArgumentException("Action must not be null");
        }
        this.action = action;
    }


    /**
     * Selects the choice and runs the action it represents.
     * <p>
     * May cause side effects
     *
     * @return The next menu that should be provided
     */
    public MenuProvider select() {
        return action.run();
    }


    @Override
    public String toString() {
        return name;
    }
}

