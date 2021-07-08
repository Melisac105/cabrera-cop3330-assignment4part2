/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;


public class Item {

    private String description;
    private String dueDate;

    public String complete;

    String name;

    public Item(String name, String description, String dueDate, String isComplete) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate; // format as shared
        this.complete = isComplete;
    }

    //getter method for item description
    public String getDescription() {
        return description;
    }

    //setter method for item description using "this."
    public void setDescription(String description) {
        this.description = description;
    }

    //getter method for due date
    public String getDueDate() {
        return dueDate;
    }

    //setter method for due date using "this."
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    //getter method complete
    public String isComplete() {
        return complete;
    }

    //setter method for complete
    public void setComplete(String complete) {
        this.complete = complete;
    }

    //getter method for name
    public String getName(String name) {
        return name;
    }

    //setter method for name
    public void setName(String name) {
        this.name = name;
    }
}
