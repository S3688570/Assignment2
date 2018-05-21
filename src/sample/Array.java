package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Array extends Person{
    //Created by Charles Galea (March 2018)

    public Array() {
    }

    ObservableList<Person> people = FXCollections.observableArrayList();

    /**
     * Constructor
     *
     * @param name
     * @param image
     * @param status
     * @param gender
     * @param age
     * @param state
     */
    public Array(String name, String image, String status, String gender, String age, String state) {
        super(name, image, status, gender, age, state);
    }


    /**
     * This method loads data from a text file and returns an observable list of people
     */

    public ObservableList<Person> getPeople() throws Exception {
        ObservableList<Person> people = FXCollections.observableArrayList();
        Scanner input = null;
        String line = null;
        input = new Scanner(new File("C:\\Data\\Database2.txt"));
        while (input.hasNextLine()) {
            String data[] = input.nextLine().split(",");
            people.add(new Person(data[0], data[1], data[2], data[3], data[4], data[5]));
        }
        return people;
    }
}