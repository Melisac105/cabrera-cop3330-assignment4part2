package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

    @Test
    void getTitle() {
        //set expected string value
        //create ToDoList object
        //assert equals
    }

    @Test
    void getCapacity() {
        //set expected int value
        //create ToDoList object
        //assert equals
    }

    @Test
    void setTitle() {
        //set expected string value
        //create ToDoList object
        //set ToDoList object title
        //assert equals
    }

    @Test
    void setCapacity() {
        //set expected int value
        //create ToDoList object
        //set ToDoList object capacity
        //assert equals
    }

    @Test
    void editTitle() {
        //change the title of a todolist
        //assert with new title
    }

    @Test
    void addItem() {
        //add a item to a list
        //call 'getCount'
        //assert if count increased
        //check if item is added
    }

    @Test
    void removeItem() {
        //call removeItem() method and remove an item from list
        //call 'getCount'
        //assert if count decreased
        //check if item is removed
    }

    @Test
    void editDescription() {
        //set expected description string
        //create item object
        //create description string
        //call 'editDescription' method and pass the item object and description string
        //assert equals
    }

    @Test
    void editDueDate() {
        //set expected due date string
        //create item object
        //create due date string
        //call 'editDueDate' method and pass the item object and due date string
        //assert equals
    }

    @Test
    void markAnItemComplete() {
        //set expected boolean value
        //create item object
        //call 'markAnItemComplete' method and pass the item object
        //assert equals
    }

    @Test
    void getItems() {
        //set expected items
        //create ToDoList object
        //assert equals
    }

}