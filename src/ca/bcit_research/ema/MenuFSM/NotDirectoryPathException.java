package ca.bcit_research.ema.MenuFSM;

/**
 * Thrown when a path does not point to a directory.
 *
 * @author Karel Chanivecky Garcia
 * @version May, 2021
 */
public class NotDirectoryPathException extends RuntimeException{
    public NotDirectoryPathException() {
        super();
    }

    public NotDirectoryPathException(String message) {
        super(message);
    }
}
