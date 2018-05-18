

package sample;

import javafx.beans.property.SimpleStringProperty;

public class Relationships extends Person{
    private SimpleStringProperty firstFriend;
    private SimpleStringProperty secondFriend;
    private SimpleStringProperty relationship;

    //Construct default constructor
    public Relationships() {

    }

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