package org.annet.dayindayout;

import java.util.ArrayList;
import java.util.Date;

import android.util.Log;

class TasksList {

	public static final String TAG = "TasksList";
	private ArrayList<Task> mTasks = new ArrayList<Task>();;
	private String mListName;
	
	private long mTasksListId;
	private String mTaskListDays;
	private char mTaskListPriority;

	public TasksList() {
		 
		Log.d(TAG, "Inside Constructor");
		
			for (int i = 0; i < 5; i++) {
				Task task = new Task();
				task.setTaskId(i);
				task.setTitle("Task: " + i);
				task.setDescription("Task" + i + "Description");
				task.setPriority('M');
				task.setDays("N");
				task.setTaskTime(new Date());
				task.setCreatedOn(new Date());

				mTasks.add(task);
			
			
			
		}

		mTaskListDays = "N";
		mTaskListPriority = 'M';
		Log.d(TAG, "Out of Constructor");
	}

	public long getTasksListId() {
		return mTasksListId;
	}

	public void setTasksListId(long tasksListId) {
		mTasksListId = tasksListId;
	}

	public String getTaskListDays() {
		return mTaskListDays;
	}

	public void setTaskListDays(String taskListDays) {
		mTaskListDays = taskListDays;
	}

	public char getTaskListPriority() {
		return mTaskListPriority;
	}

	public void setTaskListPriority(char taskListPriority) {
		mTaskListPriority = taskListPriority;
	}

	public ArrayList<Task> getTasks() {
		return mTasks;
	}

	public String getListName() {
		return mListName;
	}

	public void setListName(String listName) {
		mListName = listName;
	}

	public String toString() {
		return mListName;
	}

}
