package sample;

import java.util.Scanner;

public class Driver {
    //Created by Charles Galea (March 2018)
    Scanner input = new Scanner(System.in);

    int option;

    static Driver menuOpt = new Driver();

    //Construct a default constructor
    public Driver() {
    }

    //Method to display menu and take input
    public void displayMenu() throws Exception {

        if (option != 8) {
            do {
                System.out.println("MiniNet Menu");
                System.out.println("=========================================================");
                System.out.println("1. Add a person to the network.");
                System.out.println("2. Select a person and display their profile by name.");
                System.out.println("3. Output all profiles.");
                System.out.println("4. Connect two people as friends.");
                System.out.println("5. Are two people friends?");
                System.out.println("6. Find out the name(s) of a person's child(ren).");
                System.out.println("7. Find out the names of a persons parents.");
                System.out.println("8. Delete a person's record.");
                System.out.println("9. Quit");
            }
            while (option < 1 && option > 8);

            option = input.nextInt();

            switch (option) {
                //Add a person to the network
                case 1:
                    AddProfiles profile = new AddProfiles();
                    try {
                        profile.addProfile();
                    } catch (MyExceptions e) {
                        System.out.println("Incorrect input");
                    }
                    menuOpt.displayMenu();
                    break;

                //Select a person by name and print profile
                case 2:
                    SearchProfiles search = new SearchProfiles();
                    try {
                        search.searchName();
                    } catch (MyExceptions e) {
                        System.out.println("Incorrect input");
                    }
                    menuOpt.displayMenu();
                    break;

                //Output all profiles
                case 3:
                    Array array2 = new Array();
                    array2.getPeople();
                    menuOpt.displayMenu();
                    break;

        /*        //Connect two people as friends
                case 4:
                    //Retrieve and check ages of friends and make friends if OK
                    SetFriends setFriends = new SetFriends();
                    setFriends.checkAges();
                    menuOpt.displayMenu();
                    break;  */

                //Are two people friends?
                case 5:
                    TwoFriends twoFriends = new TwoFriends();
                    twoFriends.areFriendsFirstPerson();
                    twoFriends.areFriendsSecondPerson();
                    menuOpt.displayMenu();
                    break;

                //Find out the name(s) of a person's child(ren)
                case 6:
                    FindChildren find = new FindChildren();
                    find.findChild();
                    menuOpt.displayMenu();
                    break;

                //Find out the names of a persons parents
                case 7:
     /*               FindParents par = new FindParents();
                    par.findParents();
                    menuOpt.displayMenu();
                    break; */

                    //Delete a person's profile
                case 8:
     /*               DeleteProfile del = new DeleteProfile();
                    del.deleteProfile();
                    menuOpt.displayMenu();
                    break; */

                    //Exit menu
                case 9:
                    System.out.println("Exit");
                    break;

                //Default case for incorrect entry
                default:
                    System.out.println("Error: invalid status");
                    System.exit(1);
            }
        }
    }
}



