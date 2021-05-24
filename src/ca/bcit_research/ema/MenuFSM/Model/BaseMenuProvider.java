package ca.bcit_research.ema.MenuFSM.Model;

import java.util.ArrayList;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public abstract class BaseMenuProvider implements MenuProvider {
    protected ArrayList<Option> options = new ArrayList<>();
    private final String name;

    BaseMenuProvider(String name) throws IllegalArgumentException {

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
    public Option toOption() {
        return new Option(name, ()-> this);
    }
}
