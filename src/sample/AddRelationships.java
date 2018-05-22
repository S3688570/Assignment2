package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.Scanner;

/**
 * AddRelationship class. (For setting up a relationship
 * (friend, couple, parent, classmate, collegue) between two people).
 *
 * @author cgalea
 */
public class AddRelationships extends TextDatabase {

    Scanner input = new Scanner(System.in);

    //List variables
    private int ageDiff;
    private SimpleStringProperty firstSimpFriend;
    private SimpleStringProperty secondSimpFriend;
    private SimpleStringProperty relationship;
    private int firstPersonAge;
    private int secondPersonAge;
    private String friends;
    private String classmates;
    private String collegues;
    private String parents;
    private String couples;
    private String ageOK;
    private int error;


    //Construct default SetFriends object
    public AddRelationships() {
    }

    /**
     * Constructor for AddRelationships class.
     *
     * @param people
     * @param firstSimpFriend
     * @param secondSimpFriend
     * @param relationship
     */
    public AddRelationships(Person people, SimpleStringProperty firstSimpFriend, SimpleStringProperty secondSimpFriend, SimpleStringProperty relationship) {
        this.firstSimpFriend = firstSimpFriend;
        this.secondSimpFriend = secondSimpFriend;
        this.relationship = relationship;
        this.people = (ObservableList<Person>) people;
    }

    public int getAgeDiff() {
        return ageDiff;
    }

    public void setAgeDiff(int ageDiff) {
        this.ageDiff = ageDiff;
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

    public String getRelationship() {
        return relationship.get();
    }

    public SimpleStringProperty relationshipProperty() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship.set(relationship);
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public String getClassmates() {
        return classmates;
    }

    public void setClassmates(String classmates) {
        this.classmates = classmates;
    }

    public String getCollegues() {
        return collegues;
    }

    public void setCollegues(String collegues) {
        this.collegues = collegues;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getCouples() {
        return couples;
    }

    public void setCouples(String couples) {
        this.couples = couples;
    }

    public String getAgeOK() {
        return ageOK;
    }

    public void setAgeOK(String ageOK) {
        this.ageOK = ageOK;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }


    /**
     * This method checks the age of two people to determine whether they can form a relationship.
     *
     * @param firstSimpFriend
     * @param secondSimpFriend
     * @throws Exception
     */
    public void checkAge(SimpleStringProperty firstSimpFriend, SimpleStringProperty secondSimpFriend) throws Exception {
        boolean ageFirstOK = false;
        boolean ageSecondOK = false;

        System.out.println("Size: " + people.size() + people.toString());
        for (int i = 0; i < people.size(); i++) {
            if (firstSimpFriend.equals(people.get(i).getName())) {
                firstPersonAge = Integer.parseInt(people.get(i).getAge());
                ageFirstOK = true;
            } else if (secondSimpFriend.equals(people.get(i).getName())) {
                secondPersonAge = Integer.parseInt(people.get(i).getAge());
                ageSecondOK = true;
            } else if (ageFirstOK == false || ageSecondOK == false) {
                throw new MyExceptions("One of these people is not on this database");
            }
        }

        if (firstPersonAge < 3 || secondPersonAge < 3) {
            error = 1;
            throw new MyExceptions("Person is too young");
        } else if ((firstPersonAge > 2 && firstPersonAge < 16) && (secondPersonAge > 2 && secondPersonAge < 16)) {
            try {
                int ageDiff = Math.abs(firstPersonAge - secondPersonAge);
                System.out.println(ageDiff);
                if (ageDiff > 3) {
                    error = 1;
                }
            } catch (Exception e) {
                throw new MyExceptions("Age difference too great");
            }
        }
    }
}




