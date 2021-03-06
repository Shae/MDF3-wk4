package com.klusman.mdf3_wk4;


import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context _context;
	String data;
	WebView webview;
	int numA;
	int numB;
		

	@SuppressLint("SetJavaScriptEnabled") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _context = this;
        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
      	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        
        
        webview = (WebView) findViewById(R.id.webview);    
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/index.html");
        webview.addJavascriptInterface(new WebAppInterface(), "Android");
        
        
        Button num0 = (Button)findViewById(R.id.btn0);
        Button num1 = (Button)findViewById(R.id.btn1);
        Button num2 = (Button)findViewById(R.id.btn2);
        Button num3 = (Button)findViewById(R.id.btn3);
        Button num4 = (Button)findViewById(R.id.btn4);
        Button num5 = (Button)findViewById(R.id.btn5);
        Button num6 = (Button)findViewById(R.id.btn6);
        Button num7 = (Button)findViewById(R.id.btn7);
        Button num8 = (Button)findViewById(R.id.btn8);
        Button num9 = (Button)findViewById(R.id.btn9);
        Button btnClear = (Button)findViewById(R.id.btnClear);
        Button btnEquals = (Button)findViewById(R.id.buttonEquals);
        Button btnADD = (Button)findViewById(R.id.Add);
        Button btnSUB = (Button)findViewById(R.id.Sub);
        Button btnMULTI = (Button)findViewById(R.id.Multi);
        Button btnDIVIDE = (Button)findViewById(R.id.Divide);
        
          
        num0.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {		
				webview.loadUrl("javascript:setReadout0()");
			}
		});
        
        num1.setOnClickListener(new OnClickListener() {				
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout1()");
			}
		});
	  
        num2.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout2()");
			}
		});
	  
        num3.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout3()");
			}
		});
	  
        num4.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout4()");
			}
		});
	  
        num5.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout5()");
			}
		});
	  
        num6.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout6()");
			}
		});
	  
        num7.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout7()");
			}
		});
	  
        num8.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout8()");
			}
		});
	  
        num9.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadout9()");
			}
		});
        
        btnClear.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setReadoutClear()");
			}
		});
        
        btnADD.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setAdd()");
			}
		});
        
        btnSUB.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setSub()");
			}
		});

        btnMULTI.setOnClickListener(new OnClickListener() {	
        	@Override
        	public void onClick(View v) {
        		webview.loadUrl("javascript:setMulti()");
        	}
        });

		btnDIVIDE.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:setDivide()");
			}
		});
        
        btnEquals.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				webview.loadUrl("javascript:runEQUALS()");
			}
		});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {     
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()){				
			case R.id.menu_math:
					String url = "http://www.math.com";
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(url));
					startActivity(i);
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}  //  END onMenuItemSelected
    
    public void myToast(String text){  // Toast Template
		CharSequence textIN = text;
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(MainActivity.this, textIN, duration);
		toast.setGravity(Gravity.BOTTOM, 0, 0);
		toast.show();
	};// end myToast

    

////////////////// WEB INTERFACE /////////////////////
	class WebAppInterface{
	
		@JavascriptInterface
		public void showToast(String toast) {
		    Toast.makeText(_context, toast, Toast.LENGTH_SHORT).show();
		}
		
		@JavascriptInterface
		public void runAct(String A) {
			Intent next = new Intent(_context, AnswerActivity.class);
			next.putExtra("EXTRA", A);  
			startActivity(next);
		}
		
		
	}  //  END Class
}  // END MAINACTIVITY