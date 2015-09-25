package org.annet.dayindayout;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TasksListActivity extends ListActivity implements
		TaskTimeFragment.onTimeSelectedListener {

	public Context mAppContext;
	private ArrayList<Task> mTasksList;
	private Task mTask;
	private Task mRetainTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_list);
		mAppContext = this;
		if (mTasksList == null) {
			TasksList tasksList = new TasksList();
			mTasksList = tasksList.getTasks();
		}

		TasksListAdapter aa = new TasksListAdapter(mTasksList);
		Log.d("TasksListActivity", mTasksList.toString());
		setListAdapter(aa);

	}

	public void onResume() {
		Log.d("on resume","Clicked");
		super.onResume();
		((TasksListAdapter) getListAdapter()).notifyDataSetChanged();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Toast.makeText(this, data.getSerializableExtra("Date").toString(),
				Toast.LENGTH_LONG).show();

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

	private class TasksListAdapter extends ArrayAdapter<Task> {

		public TasksListAdapter(ArrayList<Task> tasks) {
			super(mAppContext, 0, tasks);
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				convertView = ((Activity) mAppContext).getLayoutInflater()
						.inflate(R.layout.tasks_list, null);
			}
			Task task = getItem(position);
			mTask = task;
			Log.d("getView", mTask.getTitle());
			EditText et = (EditText) convertView
					.findViewById(R.id.tasks_list_editText);
			et.setText(task.getTitle());
			et.addTextChangedListener(new TextWatcher() {

				@Override
				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					mTask.setTitle(s.toString());
				}

				@Override
				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {

				}

				@Override
				public void afterTextChanged(Editable s) {

				}
			});

			CheckBox checkbox = (CheckBox) convertView
					.findViewById(R.id.tasks_list_checkBox);
			checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					mTask.setCompleted(isChecked);
				}
			});

			TextView timeview = (TextView) convertView
					.findViewById(R.id.tasks_list_timeView);
			timeview.setText(formatDatetoTime(mTask.getTaskTime()));
			timeview.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					mRetainTask = mTask;
					FragmentManager fm = getFragmentManager();
					TaskTimeFragment fr = new TaskTimeFragment();
					// Bundle dateBundle = new Bundle();
					// datebundle.putSerializable("Date", mTask.getTaskTime());
					// fr.setArguments(dateBundle);
					fr.show(fm, "PICK_TIME");
				}
			});
			return convertView;
		}
	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		Task task=  ((TasksListAdapter) getListAdapter()).getItem(position);
		Log.d("from on list item click", task.getTitle());
	}

	public void onTimeSelected(Date date) {
		mRetainTask.setTaskTime(date);
		((TasksListAdapter) getListAdapter()).notifyDataSetChanged();
		makeToast(date.toString());
		for (Task task : mTasksList) {
			Log.d("From Onime", task.getTitle());
			Log.d("From Onime", formatDatetoTime(task.getTaskTime()));
		}
	}

	private void makeToast(String s) {
		Toast.makeText(this, s, Toast.LENGTH_LONG).show();

	}

	private String formatDatetoTime(Date date) {
		String converteddate = (String) DateFormat.format("hh: mm", date);
		return converteddate;
	}
}
