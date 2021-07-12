package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    //initialize new task
    Item item = new Item("task1", "description1", "2021-09-15", "complete");

    @Test
    void getDescription() {
        assertEquals("description1", item.getDescription()); //assert equals
    }

    @Test
    void setDescription() {
        //set new description
        item.setDescription("description2");
        assertEquals("description2", item.getDescription()); //assert equals
    }

    @Test
    void getDueDate() {
        assertEquals("2021-09-15", item.getDueDate()); //assert equals
    }

    @Test
    void setDueDate() {
        //set new due date
        item.setDueDate("2020-09-06");
        assertEquals("2020-09-06", item.getDueDate()); //assert equals
    }

    @Test
    void isComplete() {
        assertEquals("complete", item.isComplete()); //assert equals
    }

    @Test
    void setComplete() {
        //set new task status
        item.setComplete("incomplete");
        assertEquals("incomplete", item.isComplete()); //assert equals
    }

    @Test
    void getName() {
        assertEquals("task1", item.getName()); //assert equals
    }

    @Test
    void setName() {
        //set new name
        item.setName("task2");
        assertEquals("task2", item.getName()); //assert equals
    }
}