package ca.bcit_research.ema.MenuFSM;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * A NavigationMenu is a Menu that provides navigation between MenuProviders.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class NavigationMenu implements MenuProvider{

    protected ArrayList<Option> options = new ArrayList<Option>();
    private final String name;

    NavigationMenu(String name, MenuProvider parentMenu) throws IllegalArgumentException {

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must be at least 1 character long");
        }

        this.name = name;

        options.add(parentMenu.toOption());
    }

    NavigationMenu(String name, MenuProvider parentMenu, MenuProvider... children) throws IllegalArgumentException {

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must be at least 1 character long");
        }

        this.name = name;

        options = new MenuProviderSerializer().getOptions(new ArrayList<>(Arrays.asList(children)), parentMenu);
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
