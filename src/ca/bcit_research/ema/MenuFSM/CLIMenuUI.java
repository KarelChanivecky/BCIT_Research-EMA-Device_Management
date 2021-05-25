package ca.bcit_research.ema.MenuFSM;

import ca.bcit_research.ema.MenuFSM.Model.MenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.MenuUI;
import ca.bcit_research.ema.MenuFSM.Model.Option;
import ca.bcit_research.ema.MenuFSM.Model.OptionSerializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class CLIMenuUI implements MenuUI {

    private final int OPTION_START_INDEX = 1;
    private final int BAD_CHOICE = -1;
    private final MenuProvider rootMenu;
    private final ArrayList<Option> alwaysAvailableOptions;

    public CLIMenuUI(MenuProvider rootMenu, MenuProvider... otherMenus) {
        this.rootMenu = rootMenu;
        this.alwaysAvailableOptions =  new OptionSerializer().getOptions(Arrays.asList(otherMenus));
    }

    @Override
    public void displayMenu() {
        printIntro();

        MenuProvider currentMenu = this.rootMenu;

        Scanner keyboardScanner = new Scanner(System.in);

        while (currentMenu != null) {
            ArrayList<Option> currentOptions = currentMenu.getOptions();
            int currentOptionsCount = currentOptions.size();
            int maxChoice = OPTION_START_INDEX + currentOptionsCount + alwaysAvailableOptions.size();

            printOptions(currentMenu, alwaysAvailableOptions);

            int choice;
            try {
                choice = getChoiceInput(keyboardScanner);
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number");
                continue;
            }

            if (choice < OPTION_START_INDEX || maxChoice < choice) {
                System.out.println("You must choose one of the given options");
                continue;
            }

            choice--;

            Option chosenOption;
            if (choice < currentOptionsCount ) {
                chosenOption = currentOptions.get(choice);
            } else {
                choice -= currentOptionsCount;
                chosenOption = alwaysAvailableOptions.get(choice);
            }

            currentMenu = chosenOption.select();

        }


    }

    private int getChoiceInput(Scanner sc) {
        String rawInput = sc.nextLine();
        return  Integer.parseInt(rawInput);

    }



    private void printOptions(MenuProvider menu, ArrayList<Option> otherOptions) {
        AtomicInteger optionNumber = new AtomicInteger(OPTION_START_INDEX);
        menu.getOptions().forEach(option -> printOption(optionNumber.getAndIncrement(), option.name()));

        if (0 < otherOptions.size()) {
            System.out.println("---------");
            otherOptions.forEach(option -> printOption(optionNumber.getAndIncrement(), option.name()));
        }


        System.out.println();
    }

    private void printOption(int optionNumber, String optionName) {
        System.out.printf("%d: %s\n", optionNumber, optionName);
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
                #########\\\\##\\
                
                """);
    }
}

