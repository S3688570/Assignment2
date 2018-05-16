package sample;

import java.util.Scanner;

public class SearchProfiles extends Array{
    //Created by Charles Galea (March 2018)

    Scanner input = new Scanner(System.in);

    private String searchPersonName;

    public SearchProfiles() {
    }

    //Method to select person's profile
    public void searchName() throws MyExceptions{
        //Input person's name
        boolean error = false;
        do {
            System.out.println("Enter the person's name: ");
            searchPersonName = input.nextLine();
            if (!searchPersonName.matches("[a-zA-Z ]+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);

        boolean person = false;
        for (int i = 0; i < list.size(); i++) {
            if (searchPersonName.equalsIgnoreCase(list.get(i).getName())) {
                person = true;
            }
        }
        if (person == false) {
            System.out.println("This person is not in this database");
            System.out.println();
        }

        //Print profile for selected person
        for (int i=0; i<list.size(); i++) {
            if (searchPersonName.equalsIgnoreCase(list.get(i).getName())) {
                System.out.println(list.get(i));
                System.out.println();
            }
        }
    }
}
