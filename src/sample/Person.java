package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Model class for a Person
 * @author Charles Galea
 */

public class Person {
    private SimpleStringProperty name;
    private SimpleStringProperty image;
    private SimpleStringProperty status;
    private SimpleStringProperty gender;
    private SimpleStringProperty age;
    private SimpleStringProperty state;

    public Person() {

    }

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
        this.name.set(name);
    }

    public String getImage() {
        return image.get();
    }

    public SimpleStringProperty imageProperty() {
        return image;
    }

    public void setImage(String image) {
        this.image.set(image);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }
}

