package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Person class. (For generating a peron's profile).
 *
 * @author cgalea
 */

public class Person {
    private SimpleStringProperty name;
    private SimpleStringProperty image;
    private SimpleStringProperty status;
    private SimpleStringProperty gender;
    private SimpleStringProperty age;
    private SimpleStringProperty state;

    /**
     * Default constructor.
     */
    public Person() {

    }

    /**
     * Constructor with defined parameters.
     *
     * @param name
     * @param image
     * @param status
     * @param gender
     * @param age
     * @param state
     */
    public Person(String name, String image, String status, String gender, String age, String state) {
        this.name = new SimpleStringProperty(name);
        this.image = new SimpleStringProperty(image);
        this.status = new SimpleStringProperty(status);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleStringProperty(age);
        this.state = new SimpleStringProperty(state);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getImage() {
        return image.get();
    }

    public SimpleStringProperty imageProperty() {
        return image;
    }

    public void setImage(String image) {
        this.image = new SimpleStringProperty(image);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status = new SimpleStringProperty(status);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = new SimpleStringProperty(gender);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age = new SimpleStringProperty(age);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state = new SimpleStringProperty(state);
    }

    public void setFirstFriend() {
    }

    public void setSecondFriend() {
    }
}
