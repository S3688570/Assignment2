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

    @FXML
    public ComboBox<String> combobox;
    ObservableList<String> list = FXCollections.observableArrayList("Mark", "Tom", "John", "Jack");

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
     //   combobox.setItems(list);
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

    //    listview.setItems(list);
    //    listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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




    public void comboChanged(ActionEvent actionEvent) {
    //    myLabel.setText(combobox.getValue());
        combobox.getItems().addAll("Ram", "Ban", "STEVE", "Ma");
    }

/*    public void buttonAction(ActionEvent actionEvent) {
        //    myLabel.setText(combobox.getValue());
        //listview.getItems().addAll("Ram", "Ban", "STEVE", "Ma");

        ObservableList<String> names;
        names = listview.getSelectionModel().getSelectedItems();
        for (String name : names) {
            System.out.println(names);
        }

    }  */
}