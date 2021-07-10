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

    ArrayList<Task> tasks;


    public ToDoList(String title, int capacity) {
        //initialize all fields
        this.title = title;
        this.capacity = capacity;
        count = 0; //initialize count equal to zero
        tasks = new ArrayList<Task>(); //make a new list for items
    }

    public String getTitle() {
        return title; //returns the title of the todolist
    }

    public void setTitle(String title) {
        this.title = title; //set new title of the todolist using "this."
    }

    public int getRemainingCapacity() {
        return capacity - count; //return the remaining capacity of the todolist
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity; //setter method for capacity using "this."
    }

    public void editTitle(String newTitle){
       this.title = newTitle; //edit title using "this.title"
    }

    public void addTask(Task i){
        tasks.add(i); //use .add to add new task in the list
        count ++; //increase counter by 1
    }

    public void removeTask(Task i){
        tasks.remove(i); //use .remove to delete item in the list
        count--; //decrease counter by 1
    }

    //this is a getter method for getting tasks inside a todolist
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void editDescription(Task i, String str){
        int index;

        //loop to find task from the list and record the index for passed task
        for(index = 0; index < count; index++) {
            //if descriptions are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setDescription(str);  //update the passed string as new description
    }

    public void editDueDate(Task i , String str){
        int index;

        //loop to find task from the list and record the index for passed task
        for(index = 0; index < count; index++){
            //if dates are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setDueDate(str); //update the passed string as new due date
    }

    public void updateName(Task i, String str){
        int index;

        //loop to find task from the list and record the index for passed task
        for(index = 0; index < count; index++){
            //if title are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setName(str); //update the passed string as new one
    }

    public void markAnItemComplete(Task i, String complete){
        int index;

        //loop to find task from the list and record the index for passed task
        for(index = 0; index<count; index++){
            //if status are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setComplete(complete); //update the passed string as complete or incomplete
    }

    public ArrayList<Task> getCompletedItems(){
        //get all tasks in list
        ArrayList<Task> completed = new ArrayList<>(); //make a temp new list
        //loop for all tasks
        for(Task i : getTasks()){
            //if complete then add into list
            if(i.isComplete().equals("complete")){
                completed.add(i);
            }
        }
        return completed; //return temp list
    }

    public ArrayList<Task> getIncompleteItems(){
        //get all tasks in list
        ArrayList<Task> incomplete = new ArrayList<>(); //make a temp new list
        //loop for all tasks
        for(Task i : getTasks()){
            //if incomplete then add into list
            if(i.isComplete().equals("incomplete")){
                incomplete.add(i);
            }
        }
        return incomplete;  //return temp list
    }

    public void clearAll(){
        //make new objects for items
        //previous all will be deleted
        tasks = new ArrayList<>();
        count = 0; //set counter equal to zero
    }
}
