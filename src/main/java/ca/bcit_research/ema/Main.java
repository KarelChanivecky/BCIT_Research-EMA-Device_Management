package ca.bcit_research.ema;

import ca.bcit_research.ema.MenuFSM.CLIMenuUI;
import ca.bcit_research.ema.MenuFSM.MockStringMenu;
import ca.bcit_research.ema.MenuFSM.Model.MenuProvider;
import ca.bcit_research.ema.MenuFSM.Model.MenuUI;
import ca.bcit_research.ema.MenuFSM.Model.NavigationMenuProvider;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
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

        MenuProvider root = new NavigationMenuProvider("Root navigator", m3, m2, m1);

        MenuUI cliMenu = new CLIMenuUI(root);
        cliMenu.displayMenu();

    }
}
