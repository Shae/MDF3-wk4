package com.klusman.mdf3_wk4;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;


public class answerActivity extends Activity{

	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	      	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	        setContentView(R.layout.answer_activity);
	        
	        
	    }
	
	
}
