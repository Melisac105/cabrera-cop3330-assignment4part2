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
        //set instance variables (title, capacity)
        this.title = title;
        this.capacity = capacity;
        count = 0; //initialize count equal to zero
        tasks = new ArrayList<>(); //initialize items equal to a new ArrayList
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
        count ++; //increase count by 1
    }

    public void removeTask(Task i){
        tasks.remove(i); //use .remove to delete item in the list
        count--; //decrease count by 1
    }

    //this is a getter method for getting tasks inside a todolist
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void editDescription(Task i, String str){
        int index;
        // loop to find if old description is the same as the new one
        for(index = 0; index < count; index++) {
            //if descriptions are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setDescription(str); //set new description
    }

    public void editDueDate(Task i , String str){
        int index;
        //loop to find if old date is the same as the new one
        for(index = 0; index<count; index++){
            //if dates are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setDueDate(str); //set new due date
    }

    public void updateName(Task i, String str){
        int index=0;
        //loop to find if old title is the same as the new one
        for(index = 0; index<count; index++){
            //if title are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setName(str); //set new title
    }

    public void markAnItemComplete(Task i, String complete){
        int index;
        //loop to find if task status is the same as the new status
        for(index = 0; index<count; index++){
            //if status are the same, then break
            if(i.equals(getTasks().get(index))) {
                break;
            }
        }
        getTasks().get(index).setComplete(complete); //set status
    }

    public ArrayList<Task> getCompletedItems(){
        ArrayList<Task> completed = new ArrayList<>();
        for(Task i : getTasks()){
            if(i.isComplete().equals("completed")){
                completed.add(i);
            }
        }
        return completed;
    }

    public ArrayList<Task> getIncompleteItems(){
        ArrayList<Task> incomplete = new ArrayList<>();
        for(Task i : getTasks()){
            if(i.isComplete().equals("incomplete")){
                incomplete.add(i);
            }
        }
        return incomplete;
    }

    public void clearAll(){
        tasks = new ArrayList<>();
        count = 0;
    }

}
