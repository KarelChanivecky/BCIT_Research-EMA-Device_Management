package ca.bcit_research.ema.MenuFSM.menus;

import ca.bcit_research.ema.HardwareModeling.KeyValue;
import ca.bcit_research.ema.MenuFSM.Model.MenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.MenuProviderSerializer;
import ca.bcit_research.ema.MenuFSM.Model.Option;
import ca.bcit_research.ema.MenuFSM.Model.ValueProvider;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class wraps a list with a menu.
 *
 * Both constructors create a menu where you can change o
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class KeyValueMenuProvider<T, E> extends NavigationMenuProvider {

    /**
     * Constructs a menu for key values. This constructor does not add an option to create new key value pairs.
     *
     * @param name The name of the category for key value pairs
     * @param keyValues a list of key value pairs
     * @param valueProvider a function that returns a new value
     */
    public KeyValueMenuProvider(String name,
                                List<KeyValue<T, E>> keyValues,
                                ValueProvider<E> valueProvider) throws IllegalArgumentException {
        super(name);
        LinkedList<MenuProvider> optionMenus = new LinkedList<>();
        keyValues.forEach(kv -> optionMenus.add(getOptionMenu(keyValues, kv, valueProvider)));

        options = new MenuProviderSerializer().getOptions(optionMenus);

    }

    /**
     * Constructs a menu for key values. This constructor adds the menu option to create new key value pairs.
     *
     * @param name The name of the category for key value pairs
     * @param keyValues a list of key value pairs
     * @param keyValueProvider a function that returns a new key value pair
     * @param valueProvider a function that returns a new value
     */
    public KeyValueMenuProvider(String name,
                                List<KeyValue<T, E>> keyValues,
                                ValueProvider<KeyValue<T, E>> keyValueProvider,
                                ValueProvider<E> valueProvider) throws IllegalArgumentException {
        this(name, keyValues, valueProvider);
        options.add(0, new Option("## Add new", () -> {
            KeyValue<T, E> newKeyValue =  getKeyValue(keyValueProvider);
            keyValues.add(0, newKeyValue);
            options.add(new Option(newKeyValue.getKey().toString(),
                    ()-> getOptionMenu(keyValues, newKeyValue, valueProvider)));
            return this;
        }));
    }

    private KeyValue<T, E> getKeyValue(ValueProvider<KeyValue<T, E>> keyValueProvider) {
        AtomicBoolean repeated = new AtomicBoolean(true);
        KeyValue<T, E> newKeyValue = null;
        while (repeated.get()) {
            repeated.set(false);
            newKeyValue =  keyValueProvider.get();
            String key = newKeyValue.getKey().toString();
            options.forEach(option -> {
                if (option.name().equals(key)) {
                    repeated.set(true);
                    System.out.println("There is already a value with such key");
                }
            });
        }
        return newKeyValue;
    }

    private MenuProvider getOptionMenu(List<KeyValue<T, E>> keyValues,
                                           KeyValue<T, E> keyValue,
                                           ValueProvider<E> valueProvider) {
        Option removeOption = new Option("## Remove", () -> {
            keyValues.remove(keyValue);
            options.removeIf(option -> option.name() == keyValue.getKey());
            return this;
        });

        Option changeOption = new Option("## Change", () -> {
            keyValue.setValue(valueProvider.get());
            return this;
        });

        Option stateOption = new Option("## Show value", () -> {
            System.out.println(keyValue.toString());
            System.out.println();
            return this;
        });
        MenuProvider newMenu = new BaseMenuProvider(keyValue.getKey().toString(),
                removeOption,
                changeOption,
                stateOption);
        newMenu.setParentMenuProvider(this);
        return newMenu;
    }
}
