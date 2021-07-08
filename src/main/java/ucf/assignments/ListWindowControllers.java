/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class ListWindowControllers {

    public TextField listName;
    public TextField taskName;
    public TextField taskDescription;


    @FXML
    public void showAllButtonClicked(ActionEvent actionEvent) {
        //show all button will start a loop for all the tasks
        //it will get all the information for each task
        //each task will be shown to screen
        //it will then show all the items inside one todolist
    }

    @FXML
    public void showCompleteItemsButtonClicked(ActionEvent actionEvent) {
        //a loop will be started for all the tasks
        //it will be checked for each task
        //if task is completed then it will be shown
        //otherwise not
    }

    @FXML
    public void showIncompleteItemsButtonClicked(ActionEvent actionEvent) {
        //a loop will be started for all the tasks
        //it will be checked for each task
        //if task is not completed then it will be shown
        //otherwise not
    }

    @FXML
    public void downloadSingleListButtonClicked(ActionEvent actionEvent) {
        //after clicking button download list
        //the name of the list will be stored in a temp variable
        //then that list will be searched in arraylist of todolists
        //after gaining reference to that list a text file will be generated
        //then user will be given a dialog box to select a directory location to store file
        //then file will be downloaded in given directory
    }

    @FXML
    public void addItemButtonClicked(ActionEvent actionEvent) {
        //upon clicking this button add item button
        // a new small pop up window may open
        //when user will input information about the task
        //then new task will be added into the todolist
    }

    @FXML
    public void doneButtonClicked(ActionEvent actionEvent) {
        //on done button clicked
        //main window will open
        //the todolist will be saved into file system
        //the newly added todolist will be shown in main window file
    }

    @FXML
    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        //this event will be called when delete task button will be pressed
        //the task will be removed from todolist window
        //then the updated list will be shown to user
    }

    public void displayAllItems() {
        //get items from todolist
        //display all items to screen
    }

    public void displayIncompleteItems() {
        //get items from todolist
        //check which items are incomplete
        //display incomplete items to screen
    }

    public void displayCompleteItems() {
        //get items from todolist
        //check which items are complete
        //display complete items to screen
    }

    public void saveAllItemsSingleToDoList() {
        //this method will be called when user click save all
        //all items of a single todolist will be get
        //all items of todolist will be written to a file
    }
}
