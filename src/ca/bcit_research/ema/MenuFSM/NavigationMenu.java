package ca.bcit_research.ema.MenuFSM;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * A NavigationMenu is a Menu that provides navigation between MenuProviders.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class NavigationMenu extends BaseMenu {


    NavigationMenu(String name, MenuProvider parentMenu) throws IllegalArgumentException {
        super(name);
    }

    NavigationMenu(String name, MenuProvider parentMenu, MenuProvider... children) throws IllegalArgumentException {

        this(name, parentMenu);

        options.add(parentMenu.toOption());
        options.addAll(new MenuProviderSerializer().getOptions(new ArrayList<>(Arrays.asList(children))));
    }

    NavigationMenu(String name, MenuProvider... children) throws IllegalArgumentException {

        super(name);

        options.addAll(new MenuProviderSerializer().getOptions(new ArrayList<>(Arrays.asList(children))));
    }

}
