package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Relations class. (For generating a peron's relationship profile).
 *
 * @author cgalea
 */
public class Relationships extends Person {
    private SimpleStringProperty firstFriend;
    private SimpleStringProperty secondFriend;
    private SimpleStringProperty relationship;

    /**
     * Default constructor
     */
    public Relationships() {
    }

    /**
     * Constructor for Relationships class with defined parameter.
     *
     * @param firstFriend
     * @param secondFriend
     * @param relationship
     */
    public Relationships(String firstFriend, String secondFriend, String relationship) {
        this.firstFriend = new SimpleStringProperty(firstFriend);
        this.secondFriend = new SimpleStringProperty(secondFriend);
        this.relationship = new SimpleStringProperty(relationship);
    }

    public String getFirstFriend() {
        return firstFriend.get();
    }

    public SimpleStringProperty firstFriendProperty() {
        return firstFriend;
    }

    public String getSecondFriend() {
        return secondFriend.get();
    }

    public SimpleStringProperty secondFriendProperty() {
        return secondFriend;
    }

    public String getRelationship() {
        return relationship.get();
    }

    public SimpleStringProperty relationshipProperty() {
        return relationship;
    }

    public void setFirstFriend(String firstFriend) {
        this.firstFriend = new SimpleStringProperty(firstFriend);
    }

    public void setSecondFriend(String secondFriend) {
        this.secondFriend = new SimpleStringProperty(secondFriend);
    }

    public void setRelationship(String relationship) {
        this.relationship = new SimpleStringProperty(relationship);
    }

}