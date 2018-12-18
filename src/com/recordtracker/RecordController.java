package com.recordtracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import java.time.LocalDate;

/**
 * Our controller class for the program aswell as the goalscene.
 *
 * @author Pär Nilsson
 * @see RecordTracker
 * @see RecordModel
 * @version 1.0
 * @since 2018-12-10
 */
public class RecordController {
    final static ObservableList<RecordModel> recordList = FXCollections.observableArrayList();
    final static ObservableList<RecordModel> goalList = FXCollections.observableArrayList();

    public enum INPUT_TYPES {
        RECORD, GOAL
    }
    /**
     * When creating a new record this is the method we call on clicking the Add Record button.
     *
     * Taking the information we get calling the constructor in RecordModel and adding it to the Observable List which we later displays in the table view.
     * @param inputType a constant if it's a GOAL or RECORD that is sent to this method
     * @param newRecord a String describing what kind of exercise there is a new record of
     * @param newWeight a Double of the amount of weight taken in the record
     * @param newDate a LocalDate of what date the record were taken
     */
    public static void addListItem(Enum inputType, TextField newRecord, TextField newWeight, DatePicker newDate) {
        if(newRecord.getText().isEmpty() || newWeight.getText().isEmpty() || newDate.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Make sure to fill in all the fields before adding your new record or goal.");
            alert.showAndWait();
        }else {
            String record = newRecord.getText();
            Double weight = Double.parseDouble(newWeight.getText());
            LocalDate date = newDate.getValue();
            Boolean achieved = false;
            RecordModel newResult = new RecordModel(record, weight, date, achieved);
            if(inputType.equals(INPUT_TYPES.GOAL)){
                goalList.add(newResult);
            }else{
                recordList.add(newResult);
            }
        }
    }
    /**
     * Deletes the selected item from the table view.
     * @param table the table with the records
     */
    public static void removeListItem(TableView table){
        Object selectedItem = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selectedItem);
    }
}
