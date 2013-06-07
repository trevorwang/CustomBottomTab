package com.example.custombottomtabwithfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	public static final String KEY_NAME = "tab";
	public static final String TAB_FIRST = "first";
	public static final String TAB_SECOND = "second";
	public static final String TAB_THIRD = "third";
	public static final String TAB_FORTH = "forth";
	public static final String TAB_FIFTH = "5th";
	private FragmentManager mFragmentManager;
	private FragmentTabHost mTabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mFragmentManager = getSupportFragmentManager();
		setContentView(R.layout.activity_main);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, mFragmentManager, R.id.realtabcontent);
		
		Bundle args = new Bundle();
		args.putString(KEY_NAME, "Hello World!!");
		mTabHost.addTab(createSpec(TAB_FIRST, TAB_FIRST, android.R.drawable.ic_dialog_alert), SimpleFragment.class, args);

		args = new Bundle();
		args.putString(KEY_NAME, "World");
		mTabHost.addTab(createSpec(TAB_SECOND, TAB_SECOND, android.R.drawable.ic_dialog_email), SimpleFragment.class, args);
		
		args = new Bundle();
		args.putString(KEY_NAME, "TAB_THIRD");
		mTabHost.addTab(createSpec(TAB_THIRD, TAB_THIRD, android.R.drawable.ic_dialog_info), SimpleFragment.class, args);
		mTabHost.addTab(createSpec(TAB_FORTH, TAB_FORTH, android.R.drawable.ic_dialog_map), SimpleFragment.class, null);
		mTabHost.addTab(createSpec(TAB_FIFTH, TAB_FIFTH, android.R.drawable.ic_dialog_dialer), SimpleFragment.class, null);
	}

	
	/**
	 * 创建Tab按钮
	 * 
	 * @param tag
	 * @param label
	 * @param resId
	 * @return
	 */
	private TabSpec createSpec( String tag, String label, int resId) {
		View spec = View.inflate(this, R.layout.tab_indicator, null);
		ImageView icon = (ImageView) spec.findViewById(R.id.icon);
		TextView title = (TextView) spec.findViewById(R.id.title);
		icon.setImageResource(resId);
		title.setText(label);
		spec.setTag(tag); // 用来判断是否是当前tab
		return mTabHost.newTabSpec(tag).setIndicator(spec);
	}
}
