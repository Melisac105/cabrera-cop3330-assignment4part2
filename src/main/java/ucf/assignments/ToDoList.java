/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import java.util.ArrayList;

public class ToDoList {

    private String title;
    private int capacity;

    public int count;

    ArrayList<Item> items;

    public ToDoList(String title, int capacity) {

        //initialize all fields
        this.title = title;
        this.capacity = capacity;
        count = 0; //set count = 0
        items = new ArrayList<>(); //make a new list for items
    }

    public String getTitle() {
        return title; //returns the title of the todolist
    }

    public void setTitle(String title) {
        this.title = title; //set new title of the todolist using "this."
    }

    public int getRemainingCapacity() {
        return capacity-count; //return the remaining capacity of the todolist
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity; //setter method for capacity using "this."
    }

    public void editTitle(String newTitle){
        this.title = newTitle; //edit title using "this.title"
    }

    public void addItem(Item i){
        items.add(i); //use .add to add new task in the list
        count++; //increase counter by 1
    }

    public void removeItem(Item i){
        items.remove(i); //use .remove to delete item in the list
        count--; //decrease counter by 1
    }

    public void updateName(Item i, String str){
        int index;
        //loop to find task from the list and record the index for passed task
        for(index = 0; index<count; index++){
            //if name are the same, then break
            if(i.equals(getItems().get(index))) {
                break;
            }
        }
        getItems().get(index).setName(str); //update the passed string as new one
    }

    public void editDescription(Item i, String str){
        int index;
        //loop to find task from the list and record the index for passed task
        for(index = 0; index<count; index++){
            //if descriptions are the same, then break
            if(i.equals(getItems().get(index))) {
                break;
            }
        }
        getItems().get(index).setDescription(str); //update the passed string as new description
    }

    public void editDueDate(Item i , String str){
        int index;
        //loop to find task from the list and record the index for passed task
        for(index = 0; index<count; index++){
            //if dates are the same, then break
            if(i.equals(getItems().get(index))) {
                break;
            }
        }
        getItems().get(index).setDueDate(str); //update the passed string as new due date
    }

    public void markAnItemComplete(Item i, String str){
        int index;
        //loop to find task from the list and record the index for passed task
        for(index = 0; index<count; index++){
            //if status are the same, then break
            if(i.equals(getItems().get(index))) {
                break;
            }
        }
        getItems().get(index).setComplete(str); //update the passed string as complete or incomplete

    }

    //this is a getter method for getting items inside a todolist
    public ArrayList<Item> getItems(){
        return items;
    }

    public ArrayList<Item> getCompleteItems(){
        //get all items in list
        ArrayList<Item> completed = new ArrayList<>(); //make a temp new list
        //loop for all items
        for(Item i : getItems()){
            //if complete then add into list
            if(i.isComplete().equals("complete")){
                completed.add(i);
            }
        }
        return completed; //return temp list
    }

    public ArrayList<Item> getIncompleteItems(){
        //get all items in list
        ArrayList<Item> incomplete = new ArrayList<>(); //make a temp new list
        //loop for all items
        for(Item i : getItems()){
            //if incomplete then add into list
            if(i.isComplete().equals("incomplete")){
                incomplete.add(i);
            }
        }
        return incomplete; //return temp list
    }

    public void clearAll(){
        //make new objects for items
        //previous all will be deleted
        items = new ArrayList<>();
        count = 0; //set counter equal to zero
    }
}
