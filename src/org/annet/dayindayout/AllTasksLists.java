package org.annet.dayindayout;

import java.util.ArrayList;

public class AllTasksLists {

	private ArrayList<TasksList> mAllTasksLists = new ArrayList<TasksList>();
	private static AllTasksLists sAllTasksLists;

	private AllTasksLists() {
		updateSampleData();
	}

	private void updateSampleData() {
		for (int i = 0; i < 5; i++) {
			TasksList tasksList = new TasksList();
			tasksList.setListName("Task List: " + i);
			mAllTasksLists.add(tasksList);
		}
	}

	public static AllTasksLists getInstance() {
		if (sAllTasksLists == null) {
			sAllTasksLists = new AllTasksLists();
			return sAllTasksLists;
		}
		return sAllTasksLists;
	}

	public ArrayList<TasksList> getAllTasksLists() {
		return mAllTasksLists;
	}

}
