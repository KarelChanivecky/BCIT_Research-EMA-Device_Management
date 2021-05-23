package ca.bcit_research.ema.MenuFSM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Serializes the given MenuProviders as options.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class MenuProviderSerializer implements MenuSerializer {
    @Override
    public ArrayList<Option> getOptions(List<MenuProvider> menuProviders, MenuProvider...otherMenus) {
        ArrayList<Option> options = new ArrayList<>();
        AtomicInteger position = new AtomicInteger(1);
        menuProviders.forEach(menuProvider -> options.add(menuProvider.toOption(position.getAndIncrement())));
        Arrays.asList(otherMenus).forEach(menuProvider -> options.add(menuProvider.toOption(position.getAndIncrement())));
        return options;
    }
}
