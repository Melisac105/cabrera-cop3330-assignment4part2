/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import javafx.event.ActionEvent;
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
import javax.swing.*;

import java.awt.datatransfer.SystemFlavorMap;
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
    Button downloadList;

    @FXML
    Button uploadList;

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

    public void downloadAllTasks(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose a folder to save file");
        File file = directoryChooser.showDialog(null);
        System.out.println(file);
        try{
            FileWriter writeFile = new FileWriter(file.toString()+"\\todolistdownloaded.txt");
            for(Task i : myList.getTasks()){

                writeFile.write(i.toString()+"\r\n");
            }

            writeFile.close();

            JOptionPane.showMessageDialog(null, "This list has been saved in your folder");
        }

        catch(Exception e){

        }
    }


    public void loadSingleToDoList() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile!=null){
            myList.clearAll();
            Scanner fileScanner = new Scanner(selectedFile);
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                String[] lineParts = line.split(",");




                myList.addTask(new Task(lineParts[0],lineParts[1],lineParts[2],lineParts[3]));

            }

            tableView.getItems().setAll(myList.getTasks());
            capacityText.setText("Remaining Capacity: "+myList.getRemainingCapacity());

        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid File OR File not chosen");
        }
    }

    @FXML
    public void clearAll(){
        myList.clearAll();
        tableView.getItems().setAll(myList.getTasks());
        capacityText.setText("Remaining Capacity: "+myList.getRemainingCapacity());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //upon every loading file
        //all the task available in file will be loaded each time program will run

        myList = new ToDoList("My List", 100);


        try {
            File inputFile = new File("list.txt");
            Scanner fileScanner = new Scanner(inputFile);
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                String[] lineParts = line.split(",");
                myList.addTask(new Task(lineParts[0],lineParts[1],lineParts[2],lineParts[3]));
            }
        } catch(Exception e){
            System.out.println(e);
        }

        taskName.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
        desc.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
        dueDate.setCellValueFactory(new PropertyValueFactory<Task, String>("dueDate"));
        complete.setCellValueFactory(new PropertyValueFactory<Task, String>("complete"));

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

        desc.setCellFactory(TextFieldTableCell.forTableColumn());
        desc.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Task, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setDescription(t.getNewValue());

                        Task temp = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());

                        myList.editDescription(temp, t.getNewValue());
                    }
                }
        );

        dueDate.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDate.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Task, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setDueDate(t.getNewValue());

                        Task temp = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());

                        myList.editDueDate(temp, t.getNewValue());
                    }
                }
        );

        complete.setCellFactory(TextFieldTableCell.forTableColumn());
        complete.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Task, String> t) {
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow()).setComplete(t.getNewValue());

                        Task temp = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());



                        myList.markAnItemComplete(temp, t.getNewValue());
                    }
                }
        );








        addButton.setOnMouseClicked(new EventHandler() {

            //this is an event on add button
            //open a new window when add button is clciked



            @Override
            public void handle(Event event) {

                if (myList.getRemainingCapacity() <= 0) {
                    JOptionPane.showMessageDialog(null, "The list is full, delete some item");
                } else {


                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTaskWindow.fxml"));
                    Parent root = null;
                    try {
                        root = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);

                    Stage stagePrevious = (Stage) addButton.getScene().getWindow();
                    // do what you have to do
                    stagePrevious.close();
                    stage.show();
                }
            }




        });

        minusButton.setOnMouseClicked(new EventHandler() {


            //this is an event on minus button
            //delete the selected item whenever it is clicked

            @Override
            public void handle(Event event) {
                Task selectedItem = tableView.getSelectionModel().getSelectedItem();
                tableView.getItems().remove(selectedItem);
                myList.removeTask(selectedItem);

                capacityText.setText("Remaining Capacity: "+myList.getRemainingCapacity());

            }




        });
    }

    public static ArrayList<Task> allTasks(){
        return myList.getTasks();
    }


}
