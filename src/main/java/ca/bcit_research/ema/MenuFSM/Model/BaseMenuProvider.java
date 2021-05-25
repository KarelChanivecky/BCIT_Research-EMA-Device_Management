package ca.bcit_research.ema.MenuFSM.Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class BaseMenuProvider implements MenuProvider {
    protected ArrayList<Option> options = new ArrayList<>();
    private final String name;
    private MenuProvider parentMenuProvider = null;

    public BaseMenuProvider(String name) throws IllegalArgumentException {

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must be at least 1 character long");
        }

        this.name = name;
        options = new ArrayList<>();
    }

    public BaseMenuProvider(String name, ArrayList<Option> options) {
        this(name);
        this.options = options;
    }

    public BaseMenuProvider(String name, Option... options) {
        this(name);
        this.options.addAll(Arrays.asList(options));
    }

    /**
     * Get the options provided by this MenuProvider.
     *
     * @return An ArrayList<Option>
     */
    @Override
    public ArrayList<Option> getOptions() {
        return options;
    }

    /**
     * Get an Option representation pointing to this MenuProvider.
     *
     * The name of the option will be the name of this MenuProvider. The action will return a pointer to this MenuProvider
     *
     * @return An Option representation of this MenuProvider
     */
    @Override
    public Option toOption() {
        return new Option(name, ()-> this);
    }

    /**
     * Add an option that points to the parent MenuProvider of this MenuProvider.
     *
     * Will set the first option to be an Option to navigate to the parent MenuProvider.
     * Will append "## BACK TO: " to the parent MenuProvider name.
     *
     * If there already was a parentMenuProvider, this method will replace it.
     * If the new parentMenuProvider is null, it will remove the previous parentMenuProvider,
     * and set parentMenuProvider to null
     *
     * @param parentMenuProvider The parent MenuProvider
     */
    public void setParentMenuProvider(MenuProvider parentMenuProvider) {

        if (this.parentMenuProvider != null) {
            options.remove(0);
        }

        this.parentMenuProvider = parentMenuProvider;

        if (parentMenuProvider == null) {
            return;
        }

        Option parentOption = parentMenuProvider.toOption();
        String backOptionName = "## BACK TO: " + parentOption.name();
        Option backOption = new Option(backOptionName, parentOption.action());
        options.add(0, backOption);
    }

    @Override
    public String getName() {
        return name;
    }
}
