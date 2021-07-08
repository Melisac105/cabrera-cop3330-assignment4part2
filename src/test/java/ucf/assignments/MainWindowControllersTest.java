package ucf.assignments;

import org.junit.jupiter.api.Test;


class MainWindowControllersTest {

    @Test
    void addNewToDoList() {
        //set expected ToDoList object
        //call 'addNewToDoList' method
        //check if ToDoList object exists
        //call 'fail' if object does not exist
    }

    @Test
    void removeToDoList() {
        //set expected ToDoList object
        //call 'removeToDoList' method
        //check if ToDoList object still exists
        //call 'fail' if object still exists
    }

    @Test
    void saveAllToDoLists() {
        //call saveAllToDoLists method
        //this method will loop through all the todolists
        //it will create text files for each to do list
        //then it will store all the todolists on storage
        //assert if files exist
    }

    @Test
    void loadSingleToDoList() {
        //call loadSingleToDoList method
        //through this method a to do list will be loaded
        //user will select a text file from external storage
        //then the text file wil be loaded into a todolist
        //assert if size of arraylist is same as of file
    }

    @Test
    void loadMultipleToDoLists() {
        //call loadSingleToDoList method
        //through this method multiple to do lists will be loaded
        //user will select multiple text files from external storage
        //then the text files wil be loaded into a todolists
        //assert if size of arraylist is same as of no of files
    }
}