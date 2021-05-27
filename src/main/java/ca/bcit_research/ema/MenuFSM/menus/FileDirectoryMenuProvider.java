package ca.bcit_research.ema.MenuFSM.menus;

import ca.bcit_research.ema.MenuFSM.Model.NotDirectoryPathException;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * A FileMenu is a menu that acts on the filesystem.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public abstract class FileDirectoryMenuProvider extends BaseMenuProvider {
    protected final String workingDirectoryPath;

    public FileDirectoryMenuProvider(String name, String workingDirectoryPath)
            throws IllegalArgumentException, FileNotFoundException {
        super(name);

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
