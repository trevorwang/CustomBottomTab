CustomBottomTab
===============

## Custom your tab's layout as you like

1. Change the xml content as what you want

	```xml
	<?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="0dip"
	    android:layout_height="48dip"
	    android:layout_marginLeft="-3dip"
	    android:layout_marginRight="-3dip"
	    android:layout_weight="1"
	    android:background="@drawable/tab_indicator_bg"
	    android:padding="1dp" >

	    <ImageView
	        android:id="@+id/icon"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:layout_centerHorizontal="true" />

	    <TextView
	        android:id="@+id/title"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:layout_alignParentBottom="true"
	        android:layout_below="@id/icon"
	        android:layout_centerHorizontal="true"
	        android:textColor="@android:color/white" />

	</RelativeLayout>
	```

2. Change the java code at add tab to tabhost

	```java
		private TabSpec createSpec(String tag, String label, int resId) {
			View spec = View.inflate(this, R.layout.tab_indicator, null);
			ImageView icon = (ImageView) spec.findViewById(R.id.icon);
			TextView title = (TextView) spec.findViewById(R.id.title);
			icon.setImageResource(resId);
			title.setText(label);
			return mTabHost.newTabSpec(tag).setIndicator(spec);
		}
	```
3. Transfer data to target `fragment`

	```java
		Bundle args = new Bundle();
		args.putString(KEY_NAME, "Hello World!!");
		mTabHost.addTab(createSpec(TAB_FIRST, TAB_FIRST, android.R.drawable.ic_dialog_alert), SimpleFragment.class, args);
	```

4.	Get the Argument you transfered to the `fragment`

	```java
	private String mTitle;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		if(args != null) {
			mTitle = args.getString(MainActivity.KEY_NAME);
		}
	}
	```

##	Change the tab‘s position

```xml
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:orientation="vertical" >

	    <FrameLayout
	        android:id="@+id/realtabcontent"
	        android:layout_width="match_parent"
	        android:layout_height="0dp"
	        android:layout_weight="1" />
		<!-- 
			DO NOT need the TabWidget, FragmentTabHost will add it automaticly.
			Put this wedgit above the realtabcontent, if you want the tabs to be at the top!
		 -->
	    <android.support.v4.app.FragmentTabHost
	        android:id="@android:id/tabhost"
	        android:layout_width="match_parent"
	        android:layout_height="56dp"/>
	</LinearLayout>
```