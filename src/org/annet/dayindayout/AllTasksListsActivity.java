package org.annet.dayindayout;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class AllTasksListsActivity extends ListActivity{
	
	private ArrayList<TasksList> allTasksList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		allTasksList = AllTasksLists.getInstance().getAllTasksLists();
		ArrayAdapter<TasksList> aa = new ArrayAdapter<TasksList>(this, android.R.layout.simple_list_item_1, allTasksList);
		setListAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}



