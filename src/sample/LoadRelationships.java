package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadRelationships {

    //Created by Charles Galea (March 2018)
    static ArrayList<Relationships> listRelationships = new ArrayList<>();

    public LoadRelationships() {
    }

    public LoadRelationships(ArrayList listRelationships) {
        this.listRelationships = listRelationships;
    }

    //Load array
    public void loadRelations() {
        Scanner input = null;
        String line = null;

        try {
            input = new Scanner(new File("C:\\Data\\Relationships.txt"));
            while (input.hasNextLine()) {
                String data[] = input.nextLine().split(",");
                listRelationships.add(new Relationships(data[0], data[1], data[2]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("No Such File.");
            System.exit(0);
        }

        input.close();
    }

    //Print the social network
    public void printRelationships() {
        for (int i = 0; i < listRelationships.size(); i++) {
            System.out.println(listRelationships.get(i) + " ");
            System.out.println();
        }
    }
}


