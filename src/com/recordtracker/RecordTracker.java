package com.recordtracker;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import javafx.scene.layout.*;
import java.time.LocalDate;

/**
 * <h1>Record Tracker</h1>
 * Record Tracker is a program for tracking your personal records.
 *
 * @author Pär Nilsson
 * @see RecordController
 * @see RecordModel
 * @version 1.0
 * @since 2018-12-10
 */
public class RecordTracker extends Application {
    /**
     * Our main stage method, creating our stage for the program.
     * @param mainStage
     */
    @Override
    public void start(Stage mainStage){
        recordScene(mainStage);
        mainStage.setTitle("Record Tracker");
        mainStage.show();
    }
    /**
     * This method creates the scene for records.
     * @param mainStage
     */
    private static void recordScene(Stage mainStage){
        TableView<RecordModel> recordTable = new TableView<>();
        HBox menuHb = new HBox();
        HBox addHb = new HBox();

        Scene recordScene = new Scene(new Group());
        recordScene.getStylesheets().add("style.css");

        final Button recordSceneBtn = new Button("Your Records");
        recordSceneBtn.setMinWidth(225);
        recordSceneBtn.getStyleClass().add("menuBtn");
        final Button goalSceneBtn = new Button("Your Goals");
        goalSceneBtn.setMinWidth(225);
        goalSceneBtn.getStyleClass().add("menuBtn");
        menuHb.setSpacing(5);
        menuHb.getChildren().addAll(recordSceneBtn, goalSceneBtn);

        recordTable.setEditable(true);
        TableColumn<RecordModel, String> exerciseCol = new TableColumn<>("Exercise");
        exerciseCol.setMinWidth(150);
        exerciseCol.setCellValueFactory(new PropertyValueFactory<>("exercise"));
        exerciseCol.setSortType(TableColumn.SortType.DESCENDING);
        TableColumn<RecordModel, Double> weightCol = new TableColumn<>("Weight (kg)");
        weightCol.setMinWidth(150);
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        TableColumn<RecordModel, LocalDate> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(150);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        recordTable.setItems(RecordController.recordList);
        recordTable.getColumns().addAll(exerciseCol, weightCol, dateCol);

        final TextField addRecord = new TextField();
        addRecord.setPromptText("Exercise");
        addRecord.setMinWidth(70);
        addRecord.setMaxWidth(exerciseCol.getPrefWidth());
        final TextField addWeight = new TextField();
        addWeight.setPromptText("Weight (kg)");
        addWeight.setMinWidth(70);
        addWeight.setMaxWidth(weightCol.getPrefWidth());
        final DatePicker addDate = new DatePicker();
        addDate.setPromptText("Date");
        addDate.setMinWidth(100);
        addDate.setMaxWidth(dateCol.getPrefWidth());
        final Button addBtn = new Button("Add Record");
        addBtn.getStyleClass().add("btn");
        addBtn.setOnAction((event) -> RecordController.addListItem(RecordController.INPUT_TYPES.RECORD, addRecord, addWeight, addDate));
        final Button removeBtn = new Button("Remove Record");
        removeBtn.getStyleClass().add("btn");
        removeBtn.setOnAction((event) -> RecordController.removeListItem(recordTable));

        addHb.getChildren().addAll(addRecord, addWeight, addDate, addBtn, removeBtn);
        addHb.setSpacing(5);

        final VBox recordsVBox = new VBox();
        recordsVBox.setSpacing(5);
        recordsVBox.setPadding(new Insets(10));
        recordsVBox.getChildren().addAll(menuHb, recordTable, addHb);
        recordsVBox.getStyleClass().add("vbox");

        ((Group) recordScene.getRoot()).getChildren().addAll(recordsVBox);

        goalSceneBtn.setOnAction(event -> goalScene(mainStage));

        mainStage.setScene(recordScene);
    }
    /**
     * This method creates the scene for goals.
     * @param mainStage
     */
    private static void goalScene(Stage mainStage){
        TableView<RecordModel> goalTable = new TableView<>();
        HBox menuHb = new HBox();
        HBox addHb = new HBox();

        Scene goalScene = new Scene(new Group());
        goalScene.getStylesheets().add("style.css");

        final Button recordSceneBtn = new Button("Your Records");
        recordSceneBtn.setMinWidth(225);
        recordSceneBtn.getStyleClass().add("menuBtn");
        final Button goalSceneBtn = new Button("Your Goals");
        goalSceneBtn.setMinWidth(225);
        goalSceneBtn.getStyleClass().add("menuBtn");
        menuHb.setSpacing(5);
        menuHb.getChildren().addAll(recordSceneBtn, goalSceneBtn);

        goalTable.setEditable(true);
        TableColumn<RecordModel, String> exerciseCol = new TableColumn<>("Exercise");
        exerciseCol.setMinWidth(112);
        exerciseCol.setCellValueFactory(new PropertyValueFactory<>("exercise"));
        exerciseCol.setSortType(TableColumn.SortType.DESCENDING);
        TableColumn<RecordModel, Double> weightCol = new TableColumn<>("Weight (kg)");
        weightCol.setMinWidth(112);
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
        TableColumn<RecordModel, LocalDate> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(112);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<RecordModel, Boolean> checkBoxCol = new TableColumn<>("Achieved");
        checkBoxCol.setMinWidth(112);
        checkBoxCol.setCellValueFactory(new PropertyValueFactory<>("achieved"));
        checkBoxCol.setCellFactory(event -> new CheckBoxTableCell<>());

        goalTable.setItems(RecordController.goalList);
        goalTable.getColumns().addAll(exerciseCol, weightCol, dateCol, checkBoxCol);

        final TextField addGoal = new TextField();
        addGoal.setPromptText("Exercise");
        addGoal.setMinWidth(70);
        addGoal.setMaxWidth(exerciseCol.getPrefWidth());
        final TextField addWeight = new TextField();
        addWeight.setPromptText("Weight (kg)");
        addWeight.setMinWidth(70);
        addWeight.setMaxWidth(weightCol.getPrefWidth());
        final DatePicker addDate = new DatePicker();
        addDate.setPromptText("Date");
        addDate.setMinWidth(100);
        addDate.setMaxWidth(dateCol.getPrefWidth());
        final Button addBtn = new Button("Add Goal");
        addBtn.getStyleClass().add("btn");
        addBtn.setMinWidth(90);
        addBtn.setOnAction((event) -> RecordController.addListItem(RecordController.INPUT_TYPES.GOAL, addGoal, addWeight, addDate));
        final Button removeBtn = new Button("Remove Goal");
        removeBtn.getStyleClass().add("btn");
        removeBtn.setMinWidth(90);
        removeBtn.setOnAction((event) -> RecordController.removeListItem(goalTable));

        addHb.getChildren().addAll(addGoal, addWeight, addDate, addBtn, removeBtn);
        addHb.setSpacing(5);

        final VBox goalsVBox = new VBox();
        goalsVBox.setSpacing(5);
        goalsVBox.setPadding(new Insets(10));
        goalsVBox.getChildren().addAll(menuHb, goalTable, addHb);
        goalsVBox.getStyleClass().add("vbox");

        ((Group) goalScene.getRoot()).getChildren().addAll(goalsVBox);

        recordSceneBtn.setOnAction(event -> recordScene(mainStage));

        mainStage.setScene(goalScene);
    }
    /**
     * Launching the program.
     * @param args
     */
    public static void main(String[] args) { launch(args); }
}
