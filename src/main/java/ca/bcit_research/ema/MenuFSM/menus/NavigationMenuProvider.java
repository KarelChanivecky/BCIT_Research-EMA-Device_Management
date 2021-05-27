package ca.bcit_research.ema.MenuFSM.menus;


import ca.bcit_research.ema.MenuFSM.Model.MenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.MenuProviderSerializer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * A NavigationMenu is a Menu that provides navigation between MenuProviders.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class NavigationMenuProvider extends BaseMenuProvider {


    public NavigationMenuProvider(String name) throws IllegalArgumentException {
        super(name);
    }

    public NavigationMenuProvider(String name, LinkedList<MenuProvider> children) throws IllegalArgumentException {

        this(name);

        children.forEach(ch -> ch.setParentMenuProvider(this));

        options.addAll(new MenuProviderSerializer().getOptions(children));
    }

    public NavigationMenuProvider(String name, MenuProvider... children) throws IllegalArgumentException {
        super(name);

        if (children != null && 0 < children.length) {
            Arrays.asList(children).forEach((ch -> ch.setParentMenuProvider(this)));
            options.addAll(new MenuProviderSerializer()
                    .getOptions(Arrays.asList(children)));
        }
    }

}
