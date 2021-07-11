package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    //initialize todolist
    ToDoList myList = new ToDoList("My List",100);

    private void loadItems() throws FileNotFoundException {
        // get all the tasks from 'testdata.txt' file and adding them to todolist one by one
        File inputFile = new File("files/testdata.txt");
        Scanner fileScanner = new Scanner(inputFile);
        while(fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            String[] lineParts = line.split(",");
            myList.addItem(new Item(lineParts[0],lineParts[1],lineParts[2],lineParts[3]));
        }
    }

    @Test
    void getTitle() throws FileNotFoundException {
        //call loadItems function
        loadItems();
        assertEquals("My List",myList.getTitle()); //assert equals title
    }

    @Test
    void setTitle() throws FileNotFoundException {
        loadItems(); //call loadItems function
        myList.setTitle("My List New Name");//set myList title "My List New Name"
        assertEquals("My List New Name",myList.getTitle()); //assert equals title
    }

    @Test
    void getRemainingCapacity() throws FileNotFoundException {
        loadItems(); //call loadItems function
        assertEquals(96,myList.getRemainingCapacity()); //assert equals capacity
    }

    @Test
    void setCapacity() throws FileNotFoundException {
        loadItems(); //call loadItems function
        myList.setCapacity(150); //set myList capacity to 150
        assertEquals(146, myList.getRemainingCapacity()); //assert equals capacity
    }

    @Test
    void editTitle() throws FileNotFoundException {
        //call loadItems function
        //create new title
        //asserts equals title

    }

    @Test
    void addItem() throws FileNotFoundException {
        //call loadItems function
        //create Item temp variable
        //add temp in myList
        //assert equals

    }

    @Test
    void removeItem() throws FileNotFoundException {
        //call loadItems function
        //create Item temp variable
        //add temp in myList
        //create variable to get remaining capacity before delete
        //remove temp in myList
        //create variable to get remaining capacity after delete
        //assert equals
    }

    @Test
    void updateName() throws FileNotFoundException {
        //call loadItems function
        //create Item temp variable
        //update name in myList
        //assert equals
    }

    @Test
    void editDescription() throws FileNotFoundException {
        //call loadItems function
        //create Item temp variable
        //edit description in myList
        //assert equals
    }

    @Test
    void editDueDate() throws FileNotFoundException {
        //call loadItems function
        //create Item temp variable
        //edit due date in myList
        //assert equals
    }

    @Test
    void markAnItemComplete() {
        //call loadItems function
        //create Item temp variable
        //edit status od the task in myList
        //assert equals
    }

    @Test
    void getItems() {
        //call loadItems function
        //get all items from myList
        //assert equals
    }

    @Test
    void getCompleteItems() {
        //call loadItems function
        //get complete items from myList
        //assert equals
    }

    @Test
    void getIncompleteItems() {
        //call loadItems function
        //get incomplete items from myList
        //assert equals
    }

    @Test
    void clearAll() {
        //call loadItems function
        //clear all myList tasks
        //assert equals
    }
}