package com.klusman.mdf3_wk4;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;


public class AnswerActivity extends Activity{
	Context _context;
	String A;
	
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        _context = this;
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	      	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	        setContentView(R.layout.answer_activity);
	        
	        Bundle extras = getIntent().getExtras();
			if (extras != null) {
			    A = extras.getString("EXTRA");	
			}
			
			TextView NumAnswer = (TextView)findViewById(R.id.ansMainTxt);
			TextView subAnswer = (TextView)findViewById(R.id.textOddEven);
			if(A != null){
				NumAnswer.setText(A);
				int intA = Integer.parseInt(A);
				if(intA %2 == 0){
					subAnswer.setText("Your answer is an EVEN number!");
				}else{
					subAnswer.setText("Your answer is an ODD number!");
				}
			}
	    }


		
	////OPTIONS MENU  
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.answer_menu, menu);
			return true;
		} // END onCreateOptionsMenu
		
		@Override
		public boolean onMenuItemSelected(int featureId, MenuItem item) {
			switch (item.getItemId()){
				case R.id.menu_back:
						super.onBackPressed();
					break;					
				case R.id.menu_math:
						String url = "http://www.math.com";
						Intent i = new Intent(Intent.ACTION_VIEW);
						i.setData(Uri.parse(url));
						startActivity(i);
					break;
			}
			return super.onMenuItemSelected(featureId, item);
		}  //  END onMenuItemSelected
}
