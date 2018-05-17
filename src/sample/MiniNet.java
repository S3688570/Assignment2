package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MiniNet extends Application {

    /**
     * <h1>MiniNet</h1>
     * MiniNet is a program simulating a social network. A social network, in the simplest sense,
     * is a collection of connections linking a set of people. Each person has a profile in the
     * social network. To do this I created a interactive network called MiniNet containing profile
     * information (i.e. name, age status, profile image, friends, parents and children.
     * The program allows the user to add, search, modify and delete profiles.
     * <p>
     * <b>Note:</b> This project was an assignment completed for the course Advanced Programming
     * as part of the Master of Data Science course at RMIT (Melbourne, Australia).
     *
     * @author: Charles Galea
     * @version: 1.1
     * @since: 2014-04-19
     * </p>
     */
    //Created by Charles Galea (March 2018)

    public MiniNet() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) throws MyExceptions {

        launch(args);



        Array array = new Array();
        array.loadArray();
        array.printArray();

        LoadRelationships relationships = new LoadRelationships();
        relationships.loadRelations();
        relationships.printRelationships();

        //    LoadDatabase database = new LoadDatabase();
        //   database.loadDatabase();

        Driver menu = new Driver();
        menu.displayMenu();
    }
}


