package sample;

import java.util.Scanner;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

/**
 * FindChildren class. (For finding a person's children).
 *
 * @author cgalea
 */
public class FindChildren extends TextDatabase {

    //List variables
    private String parent;
    private int parentNumber = 10;

    /**
     * Default constructor
     */
    public FindChildren() {
    }

    public void findChild() throws MyExceptions {

        for (int i = 0; i < people.size(); i++) {
            if (parent.equalsIgnoreCase(people.get(i).getName())) {
                System.out.println(people.get(i).getName());
                System.out.println();
            }
        }

        for (int i = 0; i < people.size(); i++) {
            if (parent.equalsIgnoreCase(people.get(i).getName())) {
                parentNumber = 5;
            }
        }

        if (parentNumber == 10) {
            System.out.println("This person is not in the database.");
            System.out.println();
        }
    }
}



