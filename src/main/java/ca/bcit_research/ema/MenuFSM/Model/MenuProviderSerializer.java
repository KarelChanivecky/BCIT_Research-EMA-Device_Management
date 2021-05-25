package ca.bcit_research.ema.MenuFSM.Model;

import java.util.*;

/**
 * Serializes the given MenuProviders as options.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class MenuProviderSerializer implements MenuSerializer {
    @Override
    public ArrayList<Option> getOptions(Collection<MenuProvider> menuProviders, MenuProvider...otherMenus) {
        ArrayList<Option> options = new ArrayList<>();
        menuProviders.forEach(menuProvider -> options.add(menuProvider.toOption()));
        Arrays.asList(otherMenus).forEach(menuProvider -> options.add(menuProvider.toOption()));
        return options;
    }
}
