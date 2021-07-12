/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddTaskWindowControllers implements Initializable {

    @FXML
    DatePicker datePicker;

    @FXML
    TextField taskName;

    @FXML
    TextArea desc;

    @FXML
    Button submit;


    @FXML
    public void submitTask() {

        // this method will be called on clicking submit button
        String name = taskName.getText(); // get Task Name

        LocalDate datePicked = datePicker.getValue(); // get selected date
        String dueDate = datePicked.toString(); // convert date into string
        String description = desc.getText(); // get description

        //if statement to check if description has more than 256 characters
        if(description.length()>256){
            JOptionPane.showMessageDialog(null, "Description is more than 256 characters","Description", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // creating object for new Item
        Item newTask = new Item(name, description, dueDate, "incomplete");

        // adding this new item to the mainwindows item's list
        MainWindowControllers.getTasks().add(newTask);

        try{
            // getting list of all task from mainwindow and writing it to file named 'data.txt'
            FileWriter writeFile = new FileWriter("files/data.txt");
            for(Item i : MainWindowControllers.getTasks()){
                writeFile.write(i.toString()+"\r\n");
            }
            writeFile.close();
        } catch(Exception e){
            e.printStackTrace();
        }

        // loading new window using fxml loader that's MainWindow
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ucf/assignments/MainWindow.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        Stage stagePrevious = (Stage) submit.getScene().getWindow();
        stagePrevious.close();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // this method will be called on initialization of AddTaskController class's object
        // setting convert for datePicker element to get string from localDate and to get localDate from string by using DateTimeFormatter
        datePicker.setConverter(new StringConverter<>()
        {
            final private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            public String toString(LocalDate localDate) {
                if(localDate==null) {
                    return "";
                }
                return dateTimeFormatter.format(localDate);
            }

            public LocalDate fromString(String dateString) {
                if(dateString==null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString,dateTimeFormatter);
            }
        });
    }
}
