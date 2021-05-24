package ca.bcit_research.ema.MenuFSM;

import java.util.ArrayList;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class BaseMenu implements MenuProvider {
    protected ArrayList<Option> options = new ArrayList<>();
    private final String name;

    BaseMenu(String name) throws IllegalArgumentException {

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must be at least 1 character long");
        }

        this.name = name;

    }

    @Override
    public ArrayList<Option> getOptions() {
        return options;
    }

    @Override
    public MenuProvider select(Option option) {
        return null;
    }

    @Override
    public Option toOption() {
        return new Option(name, ()-> this);
    }
}
