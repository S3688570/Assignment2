package sample;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RelationshipController implements Initializable {

    @FXML
    private TableView<Relationships> tableViewRelationships;
    @FXML
    private TableColumn<Relationships, String> firstFriendColumn;
    @FXML
    private TableColumn<Relationships, String> secondFriendColumn;
    @FXML
    private TableColumn<Relationships, String> relationshipColumn;

    // These instance variables are used to create a new profile
    @FXML
    private javafx.scene.control.TextField firstFriendField;
    @FXML
    private javafx.scene.control.TextField secondFriendField;
    @FXML
    private javafx.scene.control.TextField relationshipField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        firstFriendColumn.setCellValueFactory(new PropertyValueFactory<Relationships, String>("firstFriend"));
        secondFriendColumn.setCellValueFactory(new PropertyValueFactory<Relationships, String>("secondFriend"));
        relationshipColumn.setCellValueFactory(new PropertyValueFactory<Relationships, String>("relationship"));

        //Load data
        tableViewRelationships.setItems(getRelationships());

        //Update table to allow for name fields to be editable
        tableViewRelationships.setEditable(true);
        firstFriendColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        secondFriendColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        relationshipColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the user to select multiple rows at once
        tableViewRelationships.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * This method will allow the user to double click  on a cell and update
     * the data
     */
    public void changeRelationNameCellEvent(TableColumn.CellEditEvent editedRelationCell) {
        Relationships relationSelected = tableViewRelationships.getSelectionModel().getSelectedItem();
        relationSelected.setFirstFriend(editedRelationCell.getNewValue().toString());
    }

    /**
     * This method will remove the selected row(s) from the table
     */
    public void deleteButtonPushed() {
        ObservableList<Relationships> selectedRows, allRelations;
        allRelations = tableViewRelationships.getItems();

        //this gives us rows that are selected
        selectedRows = tableViewRelationships.getSelectionModel().getSelectedItems();

        //Loop over selected rows and remove the person object from the table
/*        for (Relationships relationships : selectedRows) {
            allRelationships.remove(relationships);
        }  */

    }

    /**
     * This method will create a new profile  and add it to the table
     */
    public void addNewRelationshipProfile() {
        Relationships newProfile = new Relationships(firstFriendField.getText(), secondFriendField.getText(), relationshipField.getText());

        //Get all items from table as a list, then add the new profile to the list
        tableViewRelationships.getItems().add(newProfile);
    }


    /**
     * This method will create a new GUI window for relationships
     */
    public void relationshipScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
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
