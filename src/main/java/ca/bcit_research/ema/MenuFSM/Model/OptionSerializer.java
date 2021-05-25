package ca.bcit_research.ema.MenuFSM.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Presents the options of all given MenuProviders as one list.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class OptionSerializer implements MenuSerializer{
    @Override
    public ArrayList<Option> getOptions(Collection<MenuProvider> menuProviders, MenuProvider... otherMenus) {
        ArrayList<Option> options = new ArrayList<>();
        menuProviders.forEach(menuProvider -> options.addAll(menuProvider.getOptions()));
        Arrays.asList(otherMenus).forEach(menuProvider -> options.addAll(menuProvider.getOptions()));
        return options;
    }
}
