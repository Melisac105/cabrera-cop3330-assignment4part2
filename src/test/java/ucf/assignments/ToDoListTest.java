package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        loadItems(); //call loadItems function
        myList.editTitle("This is new title"); //create new title
        assertEquals("This is new title", myList.getTitle()); //asserts equals title

    }

    @Test
    void addItem() throws FileNotFoundException {
        loadItems(); //call loadItems function

        //create Item temp variable
        Item temp = new Item("item", "description", "2021-04-06", "incomplete");
        myList.addItem(temp); //add temp in myList
        assertEquals(temp, myList.getItems().get(myList.count-1)); //assert equals
    }

    @Test
    void removeItem() throws FileNotFoundException {
        loadItems(); //call loadItems function

        //create Item temp variable
        Item temp = new Item("item", "description", "2021-04-06", "incomplete");
        myList.addItem(temp); //add temp in myList

        //create variable to get remaining capacity before delete
        int capacityBeforeDelete = myList.getRemainingCapacity();

        myList.removeItem(temp); //remove temp in myList

        //create variable to get remaining capacity after delete
        int capacityAfterDelete = myList.getRemainingCapacity();
        assertEquals(capacityBeforeDelete,capacityAfterDelete-1); //assert equals
    }

    @Test
    void updateName() throws FileNotFoundException {
        loadItems();//call loadItems function
        Item temp = myList.getItems().get(0); //create Item temp variable
        myList.updateName(temp,"test"); //update name in myList
        assertEquals("test",myList.getItems().get(0).getName()); //assert equals
    }

    @Test
    void editDescription() throws FileNotFoundException {
        loadItems(); //call loadItems function
        Item temp = myList.getItems().get(0); //create Item temp variable
        myList.editDescription(temp,"test"); //edit description in myList
        assertEquals("test",myList.getItems().get(0).getDescription()); //assert equals
    }

    @Test
    void editDueDate() throws FileNotFoundException {
        loadItems(); //call loadItems function
        Item temp = myList.getItems().get(0); //create Item temp variable
        myList.editDueDate(temp,"2020-12-11"); //edit due date in myList
        assertEquals("2020-12-11",myList.getItems().get(0).getDueDate()); //assert equals
    }

    @Test
    void markAnItemComplete() throws FileNotFoundException {
        loadItems(); //call loadItems function
        Item temp = myList.getItems().get(0); //create Item temp variable
        myList.markAnItemComplete(temp,"complete"); //edit status od the task in myList
        assertEquals("complete",myList.getItems().get(0).isComplete()); //assert equals
    }

    @Test
    void getItems() throws FileNotFoundException {
        loadItems(); //call loadItems function
        ArrayList<Item> items = myList.getItems(); //get all items from myList
        assertEquals(4, items.size()); //assert equals
    }

    @Test
    void getCompleteItems() throws FileNotFoundException {
        loadItems(); //call loadItems function
        ArrayList<Item> items = myList.getCompleteItems(); //get complete items from myList
        assertEquals(2, items.size()); //assert equals
    }

    @Test
    void getIncompleteItems() throws FileNotFoundException {
        loadItems(); //call loadItems function
        ArrayList<Item> items = myList.getIncompleteItems(); //get incomplete items from myList
        assertEquals(2, items.size()); //assert equals
    }

    @Test
    void clearAll() throws FileNotFoundException {
        loadItems(); //call loadItems function
        myList.clearAll(); //clear all myList tasks
        assertEquals(0, myList.getItems().size()); //assert equals
    }
}