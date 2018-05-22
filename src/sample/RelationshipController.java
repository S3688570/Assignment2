package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * FXML RelationshipController. (For initialization and control of Relationships GUI).
 *
 * @author cgalea
 */
public class RelationshipController implements Initializable {

    @FXML
    SimpleStringProperty relationshipType;

    @FXML
    SimpleStringProperty friend;

    @FXML
    SimpleStringProperty classmates;

    @FXML
    SimpleStringProperty collegues;

    @FXML
    SimpleStringProperty parents;

    @FXML
    SimpleStringProperty couples;

    @FXML
    String errMsg;

    @FXML
    String firstFriend;

    @FXML
    String secondFriend;

    @FXML
    int error;

    @FXML
    private SimpleStringProperty searchPersonName;
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

    @FXML
    private ComboBox relationBox;

    @FXML
    private ComboBox<String> relationComboBox;

    @FXML
    ObservableList<String> relationshipList = FXCollections.observableArrayList("Classmates", "Collegues", "Friends", "Parents");

    private Person selectedFirstPerson;
    private Person selectedSecondPerson;
    private int firstPersonAge;
    private int secondPersonAge;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initializes the comboboxes for selecting relation type
        relationComboBox.getItems().addAll("Classmates", "Collegues", "Friends", "Parents");

        firstFriendColumn.setCellValueFactory(new PropertyValueFactory<Relationships, String>("firstFriend"));
        secondFriendColumn.setCellValueFactory(new PropertyValueFactory<Relationships, String>("secondFriend"));
        relationshipColumn.setCellValueFactory(new PropertyValueFactory<Relationships, String>("relationship"));


        /**
         * This method loads the relationship data
         */
        LoadRelationships loadRelationships = new LoadRelationships();
        try {
            tableViewRelationships.setItems(loadRelationships.getRelationships());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Relationship file does not exist!");
            alert.setContentText("Please try the database.");

            alert.showAndWait();
        }

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
    public void deleteRelationshipButtonPushed() {
        ObservableList<Relationships> selectedRowsRelations, allRelations;
        allRelations = tableViewRelationships.getItems();

        //this gives us rows that are selected
        selectedRowsRelations = tableViewRelationships.getSelectionModel().getSelectedItems();

        //Loop over selected rows and remove the person object from the table
        for (Relationships relationships : selectedRowsRelations) {
            allRelations.remove(relationships);
        }
    }

    public void relationComboChanged(ActionEvent actionEvent) {
        relationshipField.setText(relationComboBox.getValue());
    }


    /**
     * This method will create a new profile  and add it to the table
     */
    public void addNewRelationshipProfile() throws Exception {
        firstFriend = firstFriendField.getText();
        SimpleStringProperty firstSimpFriend = new SimpleStringProperty(firstFriend);
        secondFriend = secondFriendField.getText();
        SimpleStringProperty secondSimpFriend = new SimpleStringProperty(secondFriend);

        //    AddRelationships addRel = new AddRelationships();
        //    addRel.checkAge(firstSimpFriend, secondSimpFriend);
        try {
            if (error != 1) {
                Relationships newProfile = new Relationships(firstFriendField.getText(), secondFriendField.getText(), relationshipField.getText());

                //Get all items from table as a list, then add the new profile to the list
                tableViewRelationships.getItems().add(newProfile);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("These people cannot be friends.");
            alert.setContentText("They are either too young or the age difference is too great");

            alert.showAndWait();
        }
    }


    /**
     * This method will create a new GUI window for relationships
     */
    public void relationshipScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainController.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
