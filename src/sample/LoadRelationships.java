package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * LoadRelationships class. (For uploading data describing the relationships
 * between people in the database).
 *
 * @author cgalea
 */
public class LoadRelationships {

    ObservableList<Relationships> relationships = FXCollections.observableArrayList();

    public LoadRelationships() {
    }

    /**
     * This method loads data from a text file
     */
    public ObservableList<Relationships> getRelationships() throws Exception {
        ObservableList<Relationships> relationships = FXCollections.observableArrayList();
        Scanner input = null;
        String line = null;

        input = new Scanner(new File("C:\\Data\\Relationships.txt"));
        while (input.hasNextLine()) {
            String data[] = input.nextLine().split(",");
            relationships.add(new Relationships(data[0], data[1], data[2]));
        }
        return relationships;
    }
}


