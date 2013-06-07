package com.example.custombottomtabwithfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
	private String mTitle;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		if(args != null) {
			mTitle = args.getString(MainActivity.KEY_NAME);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView tv = new TextView(getActivity());
		tv.setText(" + " + mTitle);
		tv.setBackgroundResource(android.R.color.background_light);
		tv.setTextColor(Color.BLACK);
		return tv;
	}
}
