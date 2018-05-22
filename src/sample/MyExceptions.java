package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * MyExceptions class. (Customized error exceptions).
 *
 * @author cgalea
 */
public class MyExceptions extends Exception {

    /**
     * Default constructor
     */
    public MyExceptions() {
    }

    /**
     * Generic error message for passing multiple error messages
     *
     * @param message
     */
    public MyExceptions(String message) {
        super(message);
        //Error Message
    }

    /**
     * Not to be friends exception. More than 3 years difference between two children.
     *
     * @param errMsg
     * @param ageDiff
     */
    public MyExceptions(String errMsg, int ageDiff) {
        super(errMsg);
        System.out.println("The age difference is too great for these children");
    }

    /**
     * Too Young Exception
     *
     * @param errMsg
     * @param firstSimpFriend
     * @param secondSimpFriend
     */
    public MyExceptions(String errMsg, SimpleStringProperty firstSimpFriend, SimpleStringProperty secondSimpFriend) {
        super(errMsg);
        System.out.println("Too Young Exception");
    }


}





