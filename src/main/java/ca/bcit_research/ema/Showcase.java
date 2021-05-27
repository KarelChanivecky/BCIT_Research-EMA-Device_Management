package ca.bcit_research.ema;

import ca.bcit_research.ema.HardwareModeling.KeyValue;
import ca.bcit_research.ema.MenuFSM.CLIFsmDriver;
import ca.bcit_research.ema.MenuFSM.menus.MockStringMenu;
import ca.bcit_research.ema.MenuFSM.menus.KeyValueMenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.MenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.FSMDriver;
import ca.bcit_research.ema.MenuFSM.menus.NavigationMenuProvider;
import ca.bcit_research.ema.HardwareModeling.OtherPropertyKeyValueProvider;

import java.util.ArrayList;
import java.util.Scanner;

public class Showcase {

    public static void main(String[] args) {

        // showcasing NavigationMenuProvider
        // The MockStringMenus are joined together by the NavigationMenuProvider
        // The NavigationMenuProvider will take the name of each submenu and present it as an option
        // when the user selects the option, they navigate into the submenu
        MenuProvider m33 = new MockStringMenu("mock 3, 3", "opt1", "opt2", "opt3");
        MenuProvider m32 = new MockStringMenu("mock 3, 2", "opt3", "opt4", "opt5");
        MenuProvider m31 = new MockStringMenu("mock 3, 1", "opt7", "opt8", "opt9");
        MenuProvider m3 = new NavigationMenuProvider("mock 3 navigator", m33, m32, m31);

        MenuProvider m23 = new MockStringMenu("mock 2, 3", "opt10", "opt11", "opt12");
        MenuProvider m22 = new MockStringMenu("mock 2, 2", "opt13", "opt14", "opt15");
        MenuProvider m21 = new MockStringMenu("mock 2, 1", "opt16", "opt17", "opt18");
        MenuProvider m2 = new NavigationMenuProvider("mock 2 navigator", m23, m22, m21);

        MenuProvider m13 = new MockStringMenu("mock 1, 3", "opt19", "opt20", "opt21");
        MenuProvider m12 = new MockStringMenu("mock 1, 2", "opt22", "opt23", "opt24");
        MenuProvider m11 = new MockStringMenu("mock 1, 1", "opt25", "opt26", "opt27");
        MenuProvider m1 = new NavigationMenuProvider("mock 1 navigator", m13, m12, m11);

        // Showcasing the KeyValueMenuProvider.
        // The KeyValueMenuProvider will present the items in a list of KeyValues as a menu.
        // First it shows a menu of the keys. When navigating into the KeyValue, then you get options to remove,
        // or see the value.
        // Depending on the constructor used, you also get an option to add new KeyValues
        // The Lambda is a ValueProvider. ValueProviders are used so you can have dynamic types. That means that
        // KeyValues are not limited to Strings or reading from input!
        ArrayList<KeyValue<String, String>> otherProperties = new ArrayList<>();
        MenuProvider otherPropertiesMenu = new KeyValueMenuProvider<>(
                "Other properties",
                otherProperties,
                new OtherPropertyKeyValueProvider(),
                () -> {
                    System.out.println("Enter a new value");
                    return new Scanner(System.in).nextLine();
                }
        );

        // NavigationMenuProviders can also accept other NavigationMenuProviders
        MenuProvider root = new NavigationMenuProvider("Root navigator", m3, m2, m1, otherPropertiesMenu);

        FSMDriver cliMenu = new CLIFsmDriver(root);
        cliMenu.displayMenu();

    }
}
