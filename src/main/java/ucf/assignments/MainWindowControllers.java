/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;


public class MainWindowControllers implements Initializable{

    private static ToDoList myList;

    @FXML
    TableView<Task> tableView;
    @FXML
    TableColumn<Task,String> taskName;
    @FXML
    TableColumn<Task, String> desc;
    @FXML
    TableColumn<Task, String> dueDate;
    @FXML
    TableColumn<Task, String> complete;

    @FXML
    ImageView addButton;
    @FXML
    ImageView minusButton;

    @FXML
    Label capacityText;

    @FXML
    MenuItem showAll;
    @FXML
    MenuItem showComplete;
    @FXML
    MenuItem showIncomplete;

    public static ArrayList<Task> allTasks(){
        return myList.getTasks();
    }

    @FXML
    public void displayAllItems() {
        ArrayList<Task> allTasks = myList.getTasks(); //create array list that get all tasks
        tableView.getItems().setAll(allTasks); //show all tasks
    }

    @FXML
    public void displayCompleteTasks(){
        ArrayList<Task> complete = myList.getCompletedItems(); //create array list that get complete tasks
        tableView.getItems().setAll(complete); //show complete tasks
    }

    @FXML
    public void displayIncompleteTasks(){
        ArrayList<Task> incomplete = myList.getIncompleteItems(); //create array list that get complete tasks
        tableView.getItems().setAll(incomplete); //show incomplete tasks
    }


    @FXML
    public void uploadListsButtonClicked(ActionEvent actionEvent) {
        //upon clicking this button a dialog box will appear to select text file
        //the text file will contain information about multiple todolists
        //the information in text file will be used to created multiple to do lists
    }

    @FXML
    public void downloadAllListsButtonClicked(ActionEvent actionEvent) {
        //on clicking this button a text file will be generated
        //that text file will contain information about all the todolists
        //that text file will be stored in file system
        //user will be prompted to select the file location to store text file
        // finally text file will be stored on file system
    }

    public void addNewToDoList() {
        //this method will get values for adding to list from window controls
        //then a new todolist object will be created
        //that object will be added to arraylists of todolists
    }

    public void removeToDoList() {
        //this method will search for todolist in arraylist of todolists
        //if list found then it will delete the todolist from arraylist
        //it will also disable todolist from window of todolists too
    }


    public void loadSingleToDoList() {
        //user select a text file from external storage
        //text file will be loaded into a todolist
    }

    @FXML
    public void clearAll(){
        myList.clearAll();
        tableView.getItems().setAll(myList.getTasks());
        capacityText.setText("Remaining Capacity: "+myList.getRemainingCapacity());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        myList = new ToDoList("My List", 100);

        try{
            File inputFile = new File("files/emptyTable.txt");
            Scanner fileScanner = new Scanner(inputFile);
            while(fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] lineParts = line.split(",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        taskName.setCellValueFactory(new PropertyValueFactory<>("name"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        complete.setCellValueFactory(new PropertyValueFactory<>("complete"));

        tableView.getItems().setAll(myList.getTasks());

        capacityText.setText("Remaining Capacity: "+myList.getRemainingCapacity());

        addButton.setPickOnBounds(true);

        taskName.setCellFactory(TextFieldTableCell.forTableColumn());

        taskName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Task, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setName(t.getNewValue());

                        Task temp = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());

                        myList.updateName(temp, t.getNewValue());
                    }
                }
        );
    }
}
