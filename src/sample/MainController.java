package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FMXL Controller class
 *
 * @author cgalea
 */

public class MainController implements Initializable{

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
    public Label myLabel;

 /*   @FXML
    public ComboBox<String> combobox;
    ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "John", "Jack"); */

    // These instance variables are used to create a new profile
    @FXML private TextField nameField;
    @FXML private TextField imageField;
    @FXML private TextField statusField;
    @FXML private TextField genderField;
    @FXML private TextField ageField;
    @FXML private TextField stateField;

    //These items are for the Choice Box (Print Profile)
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;


    @FXML
//    public TableView<String> listview;

    /**
     * This method will allow the user to double click  on a cell and update
     * the data
     */
    public void changeNameCellEvent(TableColumn.CellEditEvent editedCell) {
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setName(editedCell.getNewValue().toString());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
     * This method will remove the selected row(s) from the table
     */
    public void deleteButtonPushed() {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();

        //this gives us rows that are selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        //Loop over selected rows and remove the person object from the table
        for (Person person: selectedRows) {
            allPeople.remove(person);
        }

    }

    /**
     * This method will create a new profile  and add it to the table
     */
    public void newProfile() {
        Person newProfile = new Person(nameField.getText(), imageField.getText(), statusField.getText(), genderField.getText(), ageField.getText(), stateField.getText());

        //Get all items from table as a list, then add the new profile to the list
        tableView.getItems().add(newProfile);

    }

    /**
     *  This method will return an ObservableList of People objects
     */
    public ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Roy Jones", "roy.image", "Working at KPMG", "M", "23", "VIC"));
        people.add(new Person("Mary Jones", "mary.image", "Working at IBM", "F", "27", "VIC"));
        people.add(new Person("Bob Blake", "bob.image", "Working at RMIT", "M", "57", "VIC"));
        people.add(new Person("Tom Lee", "tom.image", "Working at Coles", "M", "23", "QLD"));
        people.add(new Person("Marvyn Vales", "marvyn.image", "Studying at UWA", "M", "19", "WA"));
        people.add(new Person("Joy Marge", "joy.image", "Working at Microsoft", "F", "27", "ACT"));
        people.add(new Person("Jack Marge", "jack.image", "Working at Home", "M", "22", "NSW"));
        people.add(new Person("Kay Marge", "kay.image", "School", "F", "12", "NSW"));
        people.add(new Person("Kerry Kay", "kerry.image", "Working at CSR", "F", "25", "NT"));


        return people;
    }




/*    public void comboChanged(ActionEvent actionEvent) {
    //    myLabel.setText(combobox.getValue());
        combobox.getItems().addAll("Ram", "Ban", "STEVE", "Ma");
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