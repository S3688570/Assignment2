package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * TextDatabase class. (For loading personal profile data into an ObservableList).
 *
 * @author cgalea
 */
public class TextDatabase extends Person {
    //Created by Charles Galea (March 2018)

    ObservableList<Person> people = FXCollections.observableArrayList();

    public TextDatabase() {
    }

    /**
     * Constructor for Array class.
     *
     * @param name
     * @param image
     * @param status
     * @param gender
     * @param age
     * @param state
     */
    public TextDatabase(String name, String image, String status, String gender, String age, String state) {
        super(name, image, status, gender, age, state);
    }

    public void setPeople(ObservableList<Person> people) {
        this.people = people;
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





