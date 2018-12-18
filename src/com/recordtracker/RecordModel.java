package com.recordtracker;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

/**
 * Our model class with the constructor for creating new records or goals.
 *
 * @author Pär Nilsson
 * @see RecordTracker
 * @see RecordController
 * @version 1.0
 * @since 2018-12-10
 */
public class RecordModel {
    private SimpleStringProperty exercise;
    private SimpleDoubleProperty weight;
    private SimpleStringProperty date;
    private SimpleBooleanProperty achieved;
    /**
     * Our constructor for creating new Objects(records/goals) to add in the view table.
     *
     * @param exercise String with name of exercise
     * @param weight Double with mount of weight
     * @param date LocalDate when record were taken
     */
    public RecordModel(String exercise, Double weight, LocalDate date, Boolean achieved){
        this.exercise = new SimpleStringProperty(exercise);
        this.weight = new SimpleDoubleProperty(weight);
        this.date = new SimpleStringProperty(date.toString());
        this.achieved = new SimpleBooleanProperty(achieved);
    }
    /**
     * Getter for the Exercise.
     * @return String of the exercise/goal
     */
    public String getExercise() {
        return exercise.get();
    }
    /**
     * Setter for the Exercise.
     */
    public void setExercise(String newExercise) {
        exercise.set(newExercise);
    }
    /**
     * Getter for the weight.
     * @return Double of the weight
     */
    public Double getWeight() {
        return weight.get();
    }
    /**
     * Setter for the weight.
     */
    public void setWeight(Double newWeight) {
        weight.set(newWeight);
    }
    /**
     * Getter for the date.
     * @return String of the date
     */
    public String getDate() {
        return date.get();
    }
    /**
     * Setter for the weight.
     */
    public void setDate(String newDate) {
        date.set(newDate);
    }

    /**
     * Getter for the achievement
     * @return Boolean if goal is achieved or not.
     */
    public Boolean getAchieved(){
        return this.achieved.get();
    }
    /**
     * Setter for the achievement.
     */
    public void setAchieved(Boolean newAchieved){
        achieved.set(newAchieved);
    }
}
