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

    protected final ArrayList<Option> options;
    private final String name;

    NavigationMenu(String name, MenuProvider parentMenu, MenuProvider... children) throws IllegalArgumentException {

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must be at least 1 character long");
        }

        this.name = name;
        ArrayList<MenuProvider> childMenus = new ArrayList<>(Arrays.asList(children));

        options = new MenuProviderSerializer().getOptions(childMenus, parentMenu);
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
    public Option toOption(int position) {
        return new Option(position, name, ()-> this);
    }
}
