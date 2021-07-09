/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Melissa Cabrera
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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

    public void submitTask(ActionEvent actionEvent) {
        String name = taskName.getText();

        LocalDate datePicked = datePicker.getValue();

        String dueDate = datePicked.toString();
        String description = desc.getText();

        Task newTask = new Task(name, description, dueDate, "incomplete");

        MainWindowControllers.allTasks().add(newTask);

        try{
            FileWriter writeFile = new FileWriter("src/sample/data.txt");
            for(Task i : MainWindowControllers.allTasks()) {
                writeFile.write(i.toString()+"\r\n");
            }
            writeFile.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
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
    public void initialize(URL location, ResourceBundle resources) {

            datePicker.setConverter(new StringConverter<>() {
                final private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                public String toString(LocalDate localDate) {
                    if (localDate == null) {
                        return "";
                    }
                    return dateTimeFormatter.format(localDate);
                }

                public LocalDate fromString(String dateString) {
                    if (dateString == null || dateString.trim().isEmpty()) {
                        return null;
                    }
                    return LocalDate.parse(dateString, dateTimeFormatter);
                }
            });
    }
}
