package sample;

import java.util.Scanner;
import com.sun.xml.internal.bind.v2.TODO;
import java.util.Scanner;

public class FindChildren extends Array {
    //Created by Charles Galea (March 2018)

//TODO-me FindChildParents  - same last name and parent in relationship dataset
//TODO-me            - child has two parents


    Scanner input = new Scanner(System.in);

    //List variables
    private String parent;
    private int parentNumber = 10;

    public FindChildren() {
    }

    public void findChild() throws MyExceptions{
        //Enter parent's name
        boolean error = false;
        do {
            System.out.println("Please enter the name of the parent: ");
            parent = input.nextLine();
            if (!parent.matches("[a-zA-Z ]+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);


        for (int i = 0; i < list.size(); i++) {
            if (parent.equalsIgnoreCase(list.get(i).getName())) {
                System.out.println(list.get(i).getName());
                System.out.println();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (parent.equalsIgnoreCase(list.get(i).getName())) {
                parentNumber = 5;
            }
        }

        if (parentNumber == 10) {
            System.out.println("This person is not in the database.");
            System.out.println();
        }
    }
}


