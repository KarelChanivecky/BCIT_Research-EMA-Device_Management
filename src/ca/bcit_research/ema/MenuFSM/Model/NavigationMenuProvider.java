package ca.bcit_research.ema.MenuFSM.Model;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * A NavigationMenu is a Menu that provides navigation between MenuProviders.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class NavigationMenuProvider extends BaseMenuProvider {


    NavigationMenuProvider(String name) throws IllegalArgumentException {
        super(name);
    }

    NavigationMenuProvider(String name, LinkedList<MenuProvider> children) throws IllegalArgumentException {

        this(name);

        children.forEach(ch -> ch.setParentMenuProvider(this));

        options.addAll(new MenuProviderSerializer().getOptions(children));
    }

    NavigationMenuProvider(String name, MenuProvider... children) throws IllegalArgumentException {

        super(name);

        options.addAll(new MenuProviderSerializer().getOptions(new LinkedList<>(Arrays.asList(children))));
    }

}
