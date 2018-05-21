package sample;

import java.util.Scanner;

public class AddProfiles extends Array {
    //Created by Charles Galea (March 2018)

    //List variables
    private String newName;
    private String newImage;
    private String newStatus;
    private String newGender;
    private String newAge;
    private String newState;
    private boolean isNumber;


    Scanner input = new Scanner(System.in);


    //Construct default AddProfile object
    public AddProfiles() {
    }

    public String getNewName() {
        return newName;
    }

    public String getNewImage() {
        return newImage;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public String getNewGender() {
        return newGender;
    }

    public String getNewAge() {
        return newAge;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public void setNewGender(String newGender) {
        this.newGender = newGender;
    }

    public void setNewAge(String newAge) {
        this.newAge = newAge;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

    //Add person's name
    public void addProfile() throws MyExceptions {
        boolean error = false;
        do {
            System.out.println("Enter the person's name: ");
            newName = input.nextLine();
            if (!newName.matches("[a-zA-Z ]+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);

        //Add profile image
        error = false;
        do {
            System.out.println("Enter the profile image name: ");
            newImage = input.nextLine();
            if (!newImage.matches("[a-zA-Z ].+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);


        //Input the person's status
        error = false;
        do {
            System.out.println("Enter the person's status: ");
            newStatus = input.nextLine();
            if (!newStatus.matches("[a-zA-Z ]+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);


        //Input the person's gender
        error = false;
        do {
            System.out.println("Enter the person's gender: ");
            newGender = input.nextLine();
            if (!newGender.matches("[a-zA-Z ]+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);


        //Input the person's age
        do {
            System.out.println("What is the person's age: ");
            if (input.hasNext()) {
                newAge = input.next();
                isNumber = true;
            } else {
                System.out.println("Woops that is not a number. Try again: ");
                isNumber = false;
                input.next();
            }
            int newAgeInt = Integer.parseInt(newAge);
            if (newAgeInt < 0 || newAgeInt > 120) {
                System.out.println("That is an incorrect age. Try again: ");
                isNumber = false;
            }
        } while (!(isNumber));


        //Input the person's state of residence
        error = false;
        do {
            System.out.println("Enter the person's residence (e.g. VIC): ");
            newState = input.nextLine();
            newState = input.nextLine();
            if (!newState.matches("[a-zA-Z ]+")) {
                error = true;
                throw new MyExceptions("Incorrect input");
            } else {
                error = false;
            }
        } while (error == true);

        //Add new profile to ArrayList
        people.add(new Person(newName, newImage, newStatus, newGender, newAge, newState));
    }
}