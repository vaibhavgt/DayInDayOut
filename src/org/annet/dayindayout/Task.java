package org.annet.dayindayout;

import java.util.Date;

public class Task {
	
	private long mTaskId;
	private String mTitle;
	private String mDescription;
	private char mPriority;
	private Date mCreatedOn;
	private Date mTaskTime;
	private boolean mCompleted;
	private String mDays;
	
	public long getTaskId() {
		return mTaskId;
	}
	
	public void setTaskId(long taskId) {
		mTaskId = taskId;
	}
	
	public Task(){
		mTitle = "New Task";
		mDescription = "Task Description";
		mCreatedOn = new Date();
		mTaskTime = new Date();
		mCompleted = false;
		mDays = "N";
	}
	public boolean isCompleted() {
		return mCompleted;
	}
	public void setCompleted(boolean completed) {
		mCompleted = completed;
	}
	
	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String title) {
		mTitle = title;
	}
	public String getDescription() {
		return mDescription;
	}
	public void setDescription(String description) {
		mDescription = description;
	}
	public char getPriority() {
		return mPriority;
	}
	public void setPriority(char priority) {
		mPriority = priority;
	}
	public Date getCreatedOn() {
		return mCreatedOn;
	}
	public void setCreatedOn(Date createdOn) {
		mCreatedOn = createdOn;
	}
	public Date getTaskTime() {
		return mTaskTime;
	}
	public void setTaskTime(Date taskTime) {
		mTaskTime = taskTime;
	}
	public String getDays() {
		return mDays;
	}
	public void setDays(String days) {
		mDays = days;
	}
	
	public String toString(){
		return mTitle;
	}
	
}
