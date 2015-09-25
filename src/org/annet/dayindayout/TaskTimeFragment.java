package org.annet.dayindayout;

import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

public class TaskTimeFragment extends DialogFragment {
	onTimeSelectedListener mCallBack;
		int hour;
		int minute;
		
		public interface onTimeSelectedListener{
			public void onTimeSelected(Date date);
		}
		
		public void onAttach(Activity activity){
			super.onAttach(activity);
			
			try{
				mCallBack = (onTimeSelectedListener) activity;
			}
			catch(ClassCastException e){
				throw new ClassCastException(activity.toString()
	                    + " must implement OnHeadlineSelectedListener");
			}
		}

		public Dialog onCreateDialog(Bundle args) {
			
			
			View v = getActivity().getLayoutInflater().inflate(
					R.layout.time_picker, null);
			final TimePicker tp = (TimePicker) v.findViewById(R.id.task_time_picker);
			tp.setIs24HourView(false);
			/* return new AlertDialog.Builder(getActivity())
			 .setView(v)
			 .setTitle("Pick Time")
			 .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			 @Override
			 public void onClick(DialogInterface dialog, int which) {
			 Toast.makeText(
			 getActivity(),
			 "Time is : " + (tp.getCurrentHour() % 12) + ":"
			 + tp.getCurrentMinute()
			 + (tp.getCurrentHour() < 12 ? " AM" : " PM"),
			 Toast.LENGTH_LONG).show();
			
			 }
			 })
			 .create();*/
			return new TimePickerDialog(getActivity(), mTimeSetListener, hour,
					minute, false);
		}

		private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
			public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
				GregorianCalendar gc = new GregorianCalendar(0, 0, 0, hourOfDay, minuteOfHour);
				Date idate = gc.getTime();
				mCallBack.onTimeSelected(idate);
			}
		};
	
		
		
		
	}


