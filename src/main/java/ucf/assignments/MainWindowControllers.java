/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;


public class MainWindowControllers implements Initializable{

    private static ToDoList myList;

    @FXML
    TableView<Item> tableView;
    @FXML
    TableColumn<Item, String> taskName;
    @FXML
    TableColumn<Item, String> desc;
    @FXML
    TableColumn<Item, String> dueDate;
    @FXML
    TableColumn<Item, String> complete;

    @FXML
    Label capacityText;

    @FXML
    MenuItem showAll;
    @FXML
    MenuItem showComplete;
    @FXML
    MenuItem showIncomplete;

    @FXML
    ImageView addButton;
    @FXML
    ImageView minusButton;
    @FXML
    ImageView fileUpload;
    @FXML
    ImageView fileDownload;

    @FXML
    public void displayAllItems(){
        //this method will get the items from todolist
        ArrayList<Item> allItems = myList.getItems(); //get all items from todolist and store in ArrayList
        tableView.getItems().setAll(allItems); // set items from ArrayList to the tableView of window
    }

    @FXML
    public void displayIncompleteItems(){
        //this method will get the items from todolist
        ArrayList<Item> incomplete = myList.getIncompleteItems(); // get all incomplete tasks from todolist and store in ArrayList
        tableView.getItems().setAll(incomplete); // set items from ArrayList to the tableView of window
    }

    @FXML
    public void displayCompleteItems(){
        //this method will get the items from todolist
        ArrayList<Item> complete = myList.getCompleteItems(); // get all complete tasks from todolist and store in ArrayList
        tableView.getItems().setAll(complete); // set items from ArrayList to the tableView of window
    }


    @FXML
    public void clearAll() {
        //this method will clear all items from the todolist
        myList.clearAll(); //clear all items
        tableView.getItems().setAll(myList.getItems()); //set table empty in GUI
        capacityText.setText("Remaining Capacity: " + myList.getRemainingCapacity()); //get new remaining capacity
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // the method will be called on the initialization of MainWindowController's object

        myList = new ToDoList("My List", 100); // initializing todolist

        // getting all the tasks from 'data.txt' file and adding them to todolist one by one
        try {
            File inputFile = new File("files/data.txt");
            Scanner fileScanner = new Scanner(inputFile);
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                String[] lineParts = line.split(",");
                myList.addItem(new Item(lineParts[0],lineParts[1],lineParts[2],lineParts[3]));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        // setting all the tasks from the todolist to the tableView of the screen
        taskName.setCellValueFactory(new PropertyValueFactory<>("name"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        complete.setCellValueFactory(new PropertyValueFactory<>("complete"));

        tableView.getItems().setAll(myList.getItems());

        // setting remaining capacity of todolist
        capacityText.setText("Remaining Capacity: " + myList.getRemainingCapacity());

        // setting events for each column in the table view
        taskName.setCellFactory(TextFieldTableCell.forTableColumn());
        taskName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
                    // this method will be called when user try to edit any cell in the taskName column
                    @Override
                    public void handle(TableColumn.CellEditEvent<Item, String> t) {
                        // setting new name to the selected cell in the taskName column
                        ( t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());

                        // getting that item from the table into Item object
                        Item temp = ( t.getTableView().getItems().get(t.getTablePosition().getRow()));

                        myList.updateName(temp, t.getNewValue()); // updating that item's new name into todolist
                    }
                }
        );

        desc.setCellFactory(TextFieldTableCell.forTableColumn());
        desc.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
                    // this method will be called when user try to edit any cell in the description column
                    @Override
                    public void handle(TableColumn.CellEditEvent<Item, String> t) {
                        // setting new description to the selected cell in the description column
                        ( t.getTableView().getItems().get(t.getTablePosition().getRow())).setDescription(t.getNewValue());

                        // getting that item from the table into Item object
                        Item temp = ( t.getTableView().getItems().get(t.getTablePosition().getRow()));

                        myList.editDescription(temp, t.getNewValue()); // updating that item's new description into todolist
                    }
                }
        );

        dueDate.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDate.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
                    // this method will be called when user try to edit any cell in the dueDate column
                    @Override
                    public void handle(TableColumn.CellEditEvent<Item, String> t) {
                        // setting new dueDate to the selected cell in the description column
                        ( t.getTableView().getItems().get(t.getTablePosition().getRow())).setDueDate(t.getNewValue());

                        // getting that item from the table into Item object
                        Item temp = ( t.getTableView().getItems().get(t.getTablePosition().getRow()));

                        myList.editDueDate(temp, t.getNewValue()); // updating that item's new dueDate into todolist
                    }
                }
        );

        complete.setCellFactory(TextFieldTableCell.forTableColumn());
        complete.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
                    // this method will be called when user try to edit any cell in the complete column
                    @Override
                    public void handle(TableColumn.CellEditEvent<Item, String> t) {
                        // setting new complete to the selected cell in the description column
                        ( t.getTableView().getItems().get(t.getTablePosition().getRow())).setComplete(t.getNewValue());

                        // getting that item from the table into Item object
                        Item temp = ( t.getTableView().getItems().get(t.getTablePosition().getRow()));

                        myList.markAnItemComplete(temp, t.getNewValue()); // updating that item's new complete into todolist
                    }
                }
        );

        //this is an event on add button
        addButton.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                //open a new window when add button is clicked
                // if the remaining capacity of the todolist is 0 then it will just show a message dialog box to the user with a message
                if (myList.getRemainingCapacity() <= 0) {
                    new Alert(Alert.AlertType.INFORMATION, "The list is full, delete some item").show();
                } else {
                    // otherwise load a new screen using fxml loader that's AddTaskWindow.fxml to add new task
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ucf/assignments/AddTaskWindow.fxml"));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);

                    stage.setResizable(false);
                    Stage stagePrevious = (Stage) addButton.getScene().getWindow();
                    stagePrevious.close();
                    stage.show();
                }
            }
        });

        //this is an event on minus button
        minusButton.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                // getting selected item from the tableview into Item object
                Item selectedItem = tableView.getSelectionModel().getSelectedItem();

                // removing selected item from the table view
                tableView.getItems().remove(selectedItem);

                // setting remaining capacity of the todolist
                myList.removeItem(selectedItem);

                capacityText.setText("Remaining Capacity: " + myList.getRemainingCapacity());
            }
        });

        fileUpload.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                // file chooser object is created
                FileChooser fileChooser = new FileChooser();

                // set title for file chooser dialog
                fileChooser.setTitle("Open Resource File");

                // show file chooser dialog on screen to select a file and assigning selected file to the File object
                File selectedFile = fileChooser.showOpenDialog(null);

                // if user has selected any file then it will clear existing todolist first and then add all the tasks from the file into that todolist one by one using a loop
                // finally it will show all the items in the tableview and update the Remaining capacity of the todolist
                // else show a message dialog box with a message.
                if (selectedFile != null) {
                    myList.clearAll();
                    Scanner fileScanner = null;
                    try {
                        fileScanner = new Scanner(selectedFile);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (fileScanner.hasNext()) {
                        String line = fileScanner.nextLine();
                        String[] lineParts = line.split(",");

                        myList.addItem(new Item(lineParts[0], lineParts[1], lineParts[2], lineParts[3]));
                    }
                    tableView.getItems().setAll(myList.getItems());
                    capacityText.setText("Remaining Capacity: " + myList.getRemainingCapacity());
                } else {
                    new Alert(Alert.AlertType.INFORMATION, "Invalid File OR File not chosen").show();
                }
            }
        });

        fileDownload.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                // create object of DirectoryChooser
                DirectoryChooser directoryChooser = new DirectoryChooser();

                // set the title
                directoryChooser.setTitle("Choose a folder to save file");

                // call showDialog method of directoryChooser to show it on screen
                // File object will get selected directory from directoryChooser dialog
                File file = directoryChooser.showDialog(null);
                System.out.println(file);

                // file writer will write all the todotasks to the 'todolistdownloaded.txt' file in the selected directory
                //show a message dialog box when all the tasks will have been saved into the file
                try{
                    FileWriter writeFile = new FileWriter(file.toString()+"\\ListDownloaded.txt");
                    for(Item i : myList.getItems()){
                        writeFile.write(i.toString()+"\r\n");
                    }
                    writeFile.flush();
                    writeFile.close();
                    new Alert(Alert.AlertType.INFORMATION, "This list has been saved in your folder").show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //getter method for tasks
    public static ArrayList<Item> getTasks(){
        return myList.getItems();
    }


}
