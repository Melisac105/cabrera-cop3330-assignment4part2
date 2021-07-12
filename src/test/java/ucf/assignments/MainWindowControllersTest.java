package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainWindowControllersTest {

    ToDoList myList = new ToDoList("My List",100); //initialize todolist

    private void loadItems() throws FileNotFoundException {
        // get all the tasks from 'testdata.txt' file and adding them to todolist one by one
        File inputFile = new File("files/testdata.txt");
        Scanner fileScanner = new Scanner(inputFile);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] lineParts = line.split(",");
            myList.addItem(new Item(lineParts[0], lineParts[1], lineParts[2], lineParts[3]));
        }
    }

    @Test
    void displayAllItems() throws FileNotFoundException {
        loadItems(); //call loadItems function
        assertEquals(4,myList.count); //assert equals using myList
    }

    @Test
    void displayIncompleteItems() throws FileNotFoundException {
        loadItems(); //call loadItems function
        assertEquals(2, myList.getIncompleteItems().size()); //assert equals using myList
    }

    @Test
    void displayCompleteItems() throws FileNotFoundException {
        loadItems(); //call loadItems function
        assertEquals(2, myList.getCompleteItems().size()); //assert equals using myList
    }

    @Test
    void clearAll() throws FileNotFoundException {
        loadItems(); //call loadItems function
        myList.clearAll(); //clear list
        assertEquals(0, myList.getItems().size()); //assert equals using myList
    }
}