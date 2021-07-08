/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import java.util.ArrayList;

public class ToDoList {

    private String title;
    private int capacity;
    int count;

    ArrayList<Item> items;


    public ToDoList(String title, int capacity) {
        //set instance variables (title, capacity)
        this.title = title;
        this.capacity = capacity;
        //initialize count equal to zero
        count = 0;
        //initialize items equal to a new ArrayList
        items = new ArrayList<Item>();
    }

    //this method returns the title of the todolist
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        //set new title of the todolist using "this."
    }

    //this method return the capacity of the todolist
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        //setter method for capacity using "this."
    }

    public void editTitle(String newTitle){
        //edit title using "this.title"
    }

    public void addItem(Item i){
        //use .add to add new item in the list
        //increase count by 1
    }

    public void removeItem(Item i){
        //use .remove to delete item in the list
        //decrease count by 1
    }

    public void editDescription(Item i, String str){
        //this method will be passed an item and its new description
        //this method will update the description of the task provided
    }

    public void editDueDate(Item i , String str){
        //this method will be passed an item and its new due date
        //this method will update the due date of the task provided
    }

    public void markAnItemComplete(Item i){
        //this method will be passed an item
        //it will mark it complete
        //by changing boolean value
    }

    //this is a getter method for getting items inside a todolist
    public ArrayList<Item> getItems(){
        return items;
    }

}
