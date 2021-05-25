package ca.bcit_research.ema.MenuFSM;


import ca.bcit_research.ema.MenuFSM.Model.MenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.MenuUI;
import ca.bcit_research.ema.MenuFSM.Model.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class CLIMenuUI implements MenuUI {
    MenuProvider menuProvider;
    List<Option> alwaysAvailableOptions;
    private final int OPTION_START_INDEX = 1;

    public CLIMenuUI(MenuProvider menuProvider, List<Option> alwaysAvailableOptions) {
        this.menuProvider = menuProvider;
        this.alwaysAvailableOptions = alwaysAvailableOptions;
    }

    @Override
    public int getChoice() {
        System.out.printf("### %s ###%n", menuProvider.getName());
        Scanner sc = new Scanner(System.in);
        ArrayList<Option> currentOptions = menuProvider.getOptions();
        int currentOptionsCount = currentOptions.size();
        int maxChoice = OPTION_START_INDEX + currentOptionsCount + alwaysAvailableOptions.size();
        while (true) {

            printOptions(menuProvider, alwaysAvailableOptions);

            int choice;
            try {
                choice = getChoiceInput(sc);
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number");
                continue;
            }

            if (choice < OPTION_START_INDEX || maxChoice < choice) {
                System.out.println("You must choose one of the given options");
                continue;
            }

            return choice;
        }

    }


    private void printOptions(MenuProvider menu, List<Option> otherOptions) {
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


    private int getChoiceInput(Scanner sc) {
        String rawInput = sc.nextLine();
        return  Integer.parseInt(rawInput);

    }
}

