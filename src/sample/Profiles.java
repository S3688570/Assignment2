package sample;

import javafx.beans.property.SimpleStringProperty;

public class Profiles {
    private final SimpleStringProperty name;
    private final SimpleStringProperty image;
    private final SimpleStringProperty status;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty age;
    private final SimpleStringProperty state;

    public Profiles(String name, String image, String status, String gender, String age, String state) {
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

    public String getImage() {
        return image.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getAge() {
        return age.get();
    }

    public String getState() {
        return state.get();
    }
}

