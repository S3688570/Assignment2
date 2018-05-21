package sample;

import java.util.Scanner;

public class TwoFriends extends LoadRelationships {
    //Created by Charles Galea (March 2018)

    Scanner input = new Scanner(System.in);

    //List variables
    private String firstPerson;
    private String secondPerson;
    private String firstPersonFriends;
    private String secondPersonFriends;
    private int firstPersonNumber = 10;
    private int secondPersonNumber = 10;
    private String relationship;

    public TwoFriends() {
    }

    public void areFriendsFirstPerson() {
        System.out.println("Please enter the name of the first person: ");
        firstPerson = input.nextLine();
        while (!firstPerson.matches("[a-zA-Z ]+")) {
            System.out.println("Woops that's not a name!! Please try again: ");
            System.out.println("Please enter the name of the first person: ");
            firstPerson = input.nextLine();
        }

        for (int i = 0; i < relationships.size(); i++) {
            if (firstPerson.equalsIgnoreCase(relationships.get(i).getFirstFriend()) | firstPerson.equalsIgnoreCase(relationships.get(i).getSecondFriend())) {
                firstPersonNumber = 5;
            }
        }

        if (firstPersonNumber == 10) {
            System.out.println("This person is not in the database. Try again: ");
            areFriendsFirstPerson();
        }
    }

    public void areFriendsSecondPerson() {
        System.out.println("Please enter the name of the second person: ");
        secondPerson = input.nextLine();
        while (!secondPerson.matches("[a-zA-Z ]+")) {
            System.out.println("Woops that's not a name!! Please try again: ");
            System.out.println("Please enter the name of the second person: ");
            secondPerson = input.nextLine();
        }
        System.out.println();

        for (int i = 0; i < relationships.size(); i++) {
            if (secondPerson.equalsIgnoreCase(relationships.get(i).getFirstFriend()) | secondPerson.equalsIgnoreCase(relationships.get(i).getSecondFriend())) {
                secondPersonNumber = 5;
            }
        }

        if (secondPersonNumber == 10) {
            System.out.println("This person is not in the database. Try again: ");
            areFriendsSecondPerson();
        }

        //Determine the two people are friends
        for (int i = 0; i < relationships.size(); i++) {
            if (firstPerson.equalsIgnoreCase(relationships.get(i).getFirstFriend())) {
                firstPersonFriends = ((relationships.get(i).getFirstFriend()));
            } else if (firstPerson.equalsIgnoreCase(relationships.get(i).getSecondFriend())) {
                secondPersonFriends = ((relationships.get(i).getSecondFriend()));
            }
        }

        if (firstPerson.equalsIgnoreCase(secondPersonFriends)) {
            System.out.println("Yes. These two people are friends.");
        } else {
            System.out.println("No. These two people are not friends.");
        }
        System.out.println();
    }

}


