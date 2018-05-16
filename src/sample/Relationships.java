package sample;

public class Relationships extends Person{
    private String firstFriend;
    private String secondFriend;
    private String relationship;

    //Construct default constructor
    public Relationships() {

    }

    public Relationships(String firstFriend, String secondFriend, String relationship) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
        this.relationship = relationship;
    }

    public String getFirstFriend() {
        return firstFriend;
    }

    public String getSecondFriend() {
        return secondFriend;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setFirstFriend(String firstFriend) {
        this.firstFriend = firstFriend;
    }

    public void setSecondFriend(String secondFriend) {
        this.secondFriend = secondFriend;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String toString() {
        return "\n" + "First Person: " + getFirstFriend() + "\nSecond Person: " + getSecondFriend() + "\nRelationship: " + getRelationship();
    }
}

