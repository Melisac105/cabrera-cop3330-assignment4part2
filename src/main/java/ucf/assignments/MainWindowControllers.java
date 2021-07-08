/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class MainWindowControllers {
    public TextField listName;

    @FXML
    public void addListButtonClicked(ActionEvent actionEvent) {
        //this method will call the add list window
        //a new FXMLLoader will be created with the list window file
        //a new parent root will be created and this will load the list window file
        //a new scene and stage will be create to display to list window
    }

    @FXML
    public void deleteListButtonClicked(ActionEvent actionEvent) {
        //the list name will be collected
        //after search to do list name
        //the list that is to be deleted will be stored in temp variable
        //after that list will be deleted from todolist arraylist
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

    public void saveAllToDoLists() {
        //loop through all the todolists
        //create text files for each todolist
        //store all the todolists on storage
    }

    public void loadSingleToDoList() {
        //user select a text file from external storage
        //text file will be loaded into a todolist
    }

    public void loadMultipleToDoLists() {
        //user select multiple text files from external storage
        //text files will be loaded into todolists
    }



}
