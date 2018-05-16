package sample;

import java.util.Scanner;

public class SetFriends extends Array {
    //Created by Charles Galea (March 2018)

    Scanner input = new Scanner(System.in);

    //List variables
    private int ageDiff;
    private String firstFriend;
    private String secondFriend;
    private static boolean ageOK = true;
    private int firstPersonAge = 1000;
    private int secondPersonAge = 1000;
    private String relationship;

    //Construct default SetFriends object
    public SetFriends() {
    }

    public SetFriends(String firstFriend, String secondFriend, String relationship) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
        this.relationship = relationship;
    }

    //Return name of first friend
    public String getFirstFriend() {
        return firstFriend;
    }

    //Return name of second friend
    public String getSecondFriend() {
        return secondFriend;
    }

    //Set name of first friend
    public void setFirstFriend(String firstFriend) {
        this.firstFriend = firstFriend;
    }

    //Set name of second friend
    public void setSecondFriend(String secondFriend) {
        this.secondFriend = secondFriend;
    }

    //Return first person's age
    public int getFirstPersonAge() {
        return firstPersonAge;
    }

    //Return second person's age
    public int getSecondPersonAge() {
        return secondPersonAge;
    }

    //Return age difference
    public int getAgeDiff() {
        return ageDiff;
    }

    //Return boolean variable ageOK
    public static boolean isAgeOK() {
        return ageOK;
    }

    public String getRelationship() {
        return relationship;
    }

    //Check the ages of the two friends
    public void checkAges() {

        //Enter first friend
        System.out.println("Please enter the name of the first person: ");
        firstFriend = input.nextLine();
        while (!firstFriend.matches("[a-zA-Z ]+")) {
            System.out.println("Woops that's not a name!! Please try again: ");
            firstFriend = input.nextLine();
        }

        //Enter second friend
        System.out.println("Please enter the name of the second person: ");
        secondFriend = input.nextLine();
        System.out.println();
        while (!secondFriend.matches("[a-zA-Z ]+")) {
            System.out.println("Woops that's not a name!! Please try again: ");
            secondFriend = input.nextLine();
        }

        //Retrieve the ages for the two friends
        for (int i = 0; i < list.size(); i++) {
            if (firstFriend.equalsIgnoreCase(list.get(i).getName())) {
                firstPersonAge = Integer.parseInt(list.get(i).getAge());
            } else if (secondFriend.equalsIgnoreCase(list.get(i).getName())) {
                secondPersonAge = Integer.parseInt(list.get(i).getAge());
            }
        }
        if (firstPersonAge == 1000 || secondPersonAge == 1000) {
            System.out.println("One of these people is not on this database");
            System.out.println();
            ageOK = false;
        } else if (firstPersonAge < 3 || secondPersonAge < 3) {
            System.out.println("One of these people is too young to have friends.");
            System.out.println();
            ageOK = false;
        }

        //The age difference between two friends that are less than 16 years in age can not be more than 3 years
        ageDiff = Math.abs(firstPersonAge - secondPersonAge);
        if (firstPersonAge > 2 && firstPersonAge < 16 && secondPersonAge > 2 && secondPersonAge < 16 && ageDiff > 3) {
            System.out.println("The children have a greater than 3 year age difference and cannot be friends.");
            System.out.println();
            ageOK = false;
        }
        if (ageOK == true) {
            AddRelationships addRelationship = new AddRelationships();
            addRelationship.addFriend();
        }
    }
}




