package ca.bcit_research.ema.MenuFSM;

import ca.bcit_research.ema.MenuFSM.Model.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class CLIFsmDriver implements FSMDriver {

    private final MenuProvider rootMenu;
    private final ArrayList<Option> alwaysAvailableOptions;

    public CLIFsmDriver(MenuProvider rootMenu, MenuProvider... otherMenus) {
        this.rootMenu = rootMenu;
        this.alwaysAvailableOptions =  new OptionSerializer().getOptions(Arrays.asList(otherMenus));
    }

    @Override
    public void displayMenu() {
        printIntro();

        MenuProvider currentMenu = this.rootMenu;

        while (currentMenu != null) {
            MenuUI UI = new CLIMenuUI(currentMenu, alwaysAvailableOptions);

            int choice = UI.getChoice();



            currentMenu = transition(currentMenu.getOptions(), choice);

        }


    }

    private MenuProvider transition(ArrayList<Option> currentOptions, //TODO
                                    int choice) {
        choice--;

        Option chosenOption;
        if (choice < currentOptions.size()) {
            chosenOption = currentOptions.get(choice);
        } else {
            choice -= currentOptions.size();
            chosenOption = alwaysAvailableOptions.get(choice);
        }

        return chosenOption.select();
    }





    private void printIntro() {
        System.out.println("""
                BCIT Research EMA - Device Management Application
                Developers:
                - Karel Chanivecky. May, 2021.
                
                Source code: https://github.com/KarelChanivecky/BCIT_Research-EMA-Device_Management
                
                To use:
                A list of options will be presented to you. Each entry will have a number and a description, such as:
                
                1: this is an option
                
                To select the option you want, enter the number and press ENTER.
                
                Some options may require additional input from you.
                
                Enjoy!!
                
                    #
                   ### /\\
                 ######//\\ ^
                #########\\\\  \\ mr mr mr
                
                """);
    }
}
