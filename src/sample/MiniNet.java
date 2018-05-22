package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
 * @author: cgalea
 * @version: 1.1
 * @since: 2014-05-22
 * </p>
 */
public class MiniNet extends Application {

    public MiniNet() {
    }

    /**
     * Method to generate main GUI window.
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainController.fxml"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {

        launch(args);

    }
}


