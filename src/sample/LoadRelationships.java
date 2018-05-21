package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadRelationships {

    //Created by Charles Galea (March 2018)

    ObservableList<Relationships> relationships = FXCollections.observableArrayList();

    public LoadRelationships() {
    }

    /**
     * This method loads data from a text file
     */
    public ObservableList<Relationships> getRelationships() {
        ObservableList<Relationships> relationships = FXCollections.observableArrayList();
        Scanner input = null;
        String line = null;

        try {
            input = new Scanner(new File("C:\\Data\\Relationships.txt"));
            while (input.hasNextLine()) {
                String data[] = input.nextLine().split(",");
                relationships.add(new Relationships(data[0], data[1], data[2]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("No Such File.");
            System.exit(0);
        }

        input.close();
        return relationships;
    }
}


