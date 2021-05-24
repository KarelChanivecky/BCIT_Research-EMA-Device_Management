package ca.bcit_research.ema.MenuFSM.Model;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * A FileMenu is a menu that acts on the filesystem.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public abstract class FileDirectoryMenu extends NavigationMenu {
    protected final String workingDirectoryPath;

    public FileDirectoryMenu(String name, String workingDirectoryPath, MenuProvider parentMenu)
            throws IllegalArgumentException, FileNotFoundException {
        super(name, parentMenu);

        File dir = new File(workingDirectoryPath);

        if (!dir.exists()) {
            throw new FileNotFoundException("Invalid path");
        }

        if (!dir.isDirectory()) {
            throw new NotDirectoryPathException("You must enter a path");
        }

        this.workingDirectoryPath = workingDirectoryPath;
    }

}
