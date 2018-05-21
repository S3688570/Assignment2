package sample;

import java.util.Scanner;

public class AddRelationships extends Array {
    //Created by Charles Galea (March 2018)

    Scanner input = new Scanner(System.in);

    //List variables
    private int ageDiff;
    private String firstFriend;
    private String secondFriend;
    private static boolean ageFirstOK = false;
    private static boolean ageSecondOK = false;
    private int firstPersonAge;
    private int secondPersonAge;
    private String relationship;
    private String relationshipType;
    private String friends;
    private String classmates;
    private String collegues;
    private String parents;
    private String couples;


    //Construct default SetFriends object
    public AddRelationships() {
    }

    public AddRelationships(String firstFriend, String secondFriend, String relationship) {
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

    public int getFirstPersonAge() {
        return firstPersonAge;
    }

    public void setFirstPersonAge(int firstPersonAge) {
        this.firstPersonAge = firstPersonAge;
    }

    public int getSecondPersonAge() {
        return secondPersonAge;
    }

    public void setSecondPersonAge(int secondPersonAge) {
        this.secondPersonAge = secondPersonAge;
    }

    //Return age difference
    public int getAgeDiff() {
        return ageDiff;
    }

    public static boolean isAgeFirstOK() {
        return ageFirstOK;
    }

    public static void setAgeFirstOK(boolean ageFirstOK) {
        AddRelationships.ageFirstOK = ageFirstOK;
    }

    public static boolean isAgeSecondOK() {
        return ageSecondOK;
    }

    public static void setAgeSecondOK(boolean ageSecondOK) {
        AddRelationships.ageSecondOK = ageSecondOK;
    }

    public String getRelationship() {
        return relationship;
    }


    //Check the ages of the two friends
    public void checkAges() {

        //Enter first friend
        //    System.out.println("Please enter the name of the first person: ");
        //    firstFriend = input.nextLine();
        while (!firstFriend.matches("[a-zA-Z ]+")) {
            System.out.println("Woops that's not a name!! Please try again: ");
        }

        //Enter second friend
        //    System.out.println("Please enter the name of the second person: ");
        //    secondFriend = input.nextLine();
        while (!secondFriend.matches("[a-zA-Z ]+")) {
            System.out.println("Woops that's not a name!! Please try again: ");
        }

        //Retrieve the ages for the two friends
/*        for (int i = 0; i < people.size(); i++) {
            if (firstFriend.equalsIgnoreCase(people.get(i).getName())) {
                firstPersonAge = Integer.parseInt(people.get(i).getAge());
                ageFirstOK = true;
            } else if (secondFriend.equalsIgnoreCase(people.get(i).getName())) {
                secondPersonAge = Integer.parseInt(people.get(i).getAge());
                ageSecondOK = true;
            } else if (ageFirstOK == false || ageSecondOK == false) {
                System.out.println("One of these people is not on this database");
            }
        }  */
    }


    //The age difference between two friends that are less than 16 years in age can not be more than 3 years
 /*       public static void checkAge(int firstPersonAge, int secondPersonAge) throws Exception{
            int ageDiff = Math.abs(firstPersonAge - secondPersonAge);
            if (firstPersonAge > 2 && firstPersonAge < 16 || secondPersonAge > 2 && secondPersonAge < 16) {
                try {
                    if (ageDiff > 3 && relationshipType == friend) {
                        Relationships addRelationship = new Relationships();
                        addRelationship.addFriend();
                    }
                }
                catch(Exception e) {
                    throw new Exception("Too Young Exception");
                }
            }

            }  */
}