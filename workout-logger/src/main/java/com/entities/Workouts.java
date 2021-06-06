package com.entities;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="user_workout_details")

public class Workouts {
	@Id
	private int workoutId;
	private String workoutName;
	private String workoutType;
	private String workoutDetails;
	private String workoutDuration;
	private String workoutLink;
	private String workoutDate;
	public String getWorkoutDate() {
		return workoutDate;
	}
	public void setWorkoutDate(String workoutDate) {
		this.workoutDate = workoutDate;
	}
	public int getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	public String getWorkoutName() {
		return workoutName;
	}
	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}
	public String getWorkoutType() {
		return workoutType;
	}
	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}
	public String getWorkoutDetails() {
		return workoutDetails;
	}
	public void setWorkoutDetails(String workoutDetails) {
		this.workoutDetails = workoutDetails;
	}
	public String getWorkoutDuration() {
		return workoutDuration;
	}
	public void setWorkoutDuration(String workoutDuration) {
		this.workoutDuration = workoutDuration;
	}
	public String getWorkoutLink() {
		return workoutLink;
	}
	public void setWorkoutLink(String workoutLink) {
		this.workoutLink = workoutLink;
	}
	public Workouts(String workoutName, String workoutType, String workoutDetails,
			String workoutDuration, String workoutLink, String workoutDate) {
		super();
		this.workoutId = new Random().nextInt(100000);
		this.workoutName = workoutName;
		this.workoutType = workoutType;
		this.workoutDetails = workoutDetails;
		this.workoutDuration = workoutDuration;
		this.workoutLink = workoutLink;
		this.workoutDate = workoutDate;
	}
	public Workouts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
