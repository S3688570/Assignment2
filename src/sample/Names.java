package sample;

import javafx.beans.property.SimpleStringProperty;

public class Names {
    private SimpleStringProperty name;

    public Names() {

    }

    public Names(String name) {
        this.name = new SimpleStringProperty(name);
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

}

