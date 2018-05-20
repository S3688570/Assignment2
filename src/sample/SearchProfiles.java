package sample;

import java.util.Scanner;

public class SearchProfiles extends Array{
    //Created by Charles Galea (March 2018)

    private String searchPersonName;

    public SearchProfiles() {
    }

    //Method to select person's profile
    public Person searchName() throws MyExceptions{
        //Input person's name
        boolean error = false;
        do {
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
        }

        //Print profile for selected person
        for (int i=0; i<list.size(); i++) {
            if (searchPersonName.equalsIgnoreCase(list.get(i).getName())) {
                return list.get(i);
            }
        }
        return null;
    }
}
