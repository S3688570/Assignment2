package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * FMXL Controller class
 *
 * @author cgalea
 */

public class MainController implements Initializable {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TableColumn<Person, String> imageColumn;
    @FXML
    private TableColumn<Person, String> statusColumn;
    @FXML
    private TableColumn<Person, String> genderColumn;
    @FXML
    private TableColumn<Person, String> ageColumn;
    @FXML
    private TableColumn<Person, String> stateColumn;

    @FXML
    Button btnPrintProfile = new Button("Print Profile");


    @FXML
    private Button relationshipBtn;

    @FXML
    public Label myLabel;
/*  @FXML
    public ComboBox<String> genderComboBox;
    public ComboBox<String> stateComboBox; */

    @FXML
    ObservableList<String> genderList = FXCollections.observableArrayList("F", "M");
    ObservableList<String> stateList = FXCollections.observableArrayList("ACT", "QLD", "NSW", "NT", "SA", "TAS", "VIC", "WA");

    // These instance variables are used to create a new profile
    @FXML
    private TextField nameField;
    @FXML
    private TextField imageField;
    @FXML
    private TextField statusField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField stateField;

    //These items are for the Choice Box (Print Profile)
    @FXML
    private ComboBox comboBox;
    @FXML
    private Label comboBoxLabel;
    @FXML
    private ComboBox<String> genderComboBox;
    @FXML
    private ComboBox<String> stateComboBox;



 /*   @FXML
    public TableView<String> listview;  */


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderComboBox.getItems().addAll("F", "M");
        stateComboBox.getItems().addAll("ACT", "QLD", "NSW", "NT", "SA", "TAS", "VIC", "WA");

        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        imageColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("image"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("status"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("state"));

        //Load data
        tableView.setItems(getPeople());

        //Update table to allow for name fields to be editable
        tableView.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        imageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        genderColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the user to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        //    listview.setItems(list);
        //    listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }


    /**
     * This method will allow the user to double click  on a cell and update
     * the data
     */
    public void changeNameCellEvent(TableColumn.CellEditEvent editedCell) {
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setName(editedCell.getNewValue().toString());
    }

    /**
     * This method will remove the selected row(s) from the table
     */
    public void deleteButtonPushed() {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();

        //this gives us rows that are selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        //Loop over selected rows and remove the person object from the table
        for (Person person : selectedRows) {
            allPeople.remove(person);
        }

    }

    public void comboChanged(ActionEvent actionEvent) {
        genderField.setText(genderComboBox.getValue());
        stateField.setText(stateComboBox.getValue());
        //    combobox.getItems().addAll("Ram", "Ban", "STEVE", "Ma");
    }

    /**
     * This method will create a new profile  and add it to the table
     */
    public void addNewProfile() {
        Person newProfile = new Person(nameField.getText(), imageField.getText(), statusField.getText(), genderField.getText(), ageField.getText(), stateField.getText());

        //Get all items from table as a list, then add the new profile to the list
        tableView.getItems().add(newProfile);
    }

    /**
     * This method will create a new GUI window for relationships
     */
    public void databaseScreenButtonPushed(ActionEvent event) throws Exception {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("makeRelationship.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene tableViewScene = new Scene(tableViewParent);
        window.hide();
        window.setScene(tableViewScene);
        window.show();
    }



    /**
     * This method loads data from a text file
     */
    //Load array
    public ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        Scanner input = null;
        String line = null;

        try {
            input = new Scanner(new File("C:\\Data\\Database2.txt"));
            while (input.hasNextLine()) {
                String data[] = input.nextLine().split(",");
                people.add(new Person(data[0], data[1], data[2], data[3], data[4], data[5]));
            }

        } catch (FileNotFoundException e) {
            System.err.println("No Such File.");
            System.exit(0);
        }
        input.close();
        return people;
    }




 /*   @FXML
     private void changeScreenButtonPushed(ActionEvent event) throws Exception {
        GridPane pane
    }  */

/*    public void changeScreenButtonPushed(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("makeRelationship.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    } */











 /*      public void buttonAction(ActionEvent actionEvent) {
        //    myLabel.setText(combobox.getValue());
        //listview.getItems().addAll("Ram", "Ban", "STEVE", "Ma");

        ObservableList<Person> names;
        names = tableView.getSelectionModel().getSelectedItems();
        for (String name : names) {
            System.out.println(names);

        }

    }  */
}
