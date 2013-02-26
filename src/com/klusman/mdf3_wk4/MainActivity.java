package com.klusman.mdf3_wk4;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context _context;
	String data;
	WebView webview;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _context = this;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        
        
        webview = (WebView) findViewById(R.id.webview);    
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/index.html");
        webview.addJavascriptInterface(new WebAppInterface(), "Android");
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    

    


	class WebAppInterface{
		
		int answer;
	
		@JavascriptInterface
		public void showToast(String toast) {
		    Toast.makeText(_context, toast, Toast.LENGTH_SHORT).show();
		    answerActivityFunction();
		}
		
		
		@JavascriptInterface
		public void calcPlus(int a, int b)
		{
			int A = a;
			int B = b;
			int C = A+B;
			String stringC = String.valueOf(C);
			showToast(stringC);
			
		}
		
		@JavascriptInterface
		public void calcSub(int a, int b)
		{
			int A = a;
			int B = b;
			int C = A-B;
			String stringC = String.valueOf(C);
			showToast(stringC);
		}
		
		@JavascriptInterface
		public void calcMulti(int a, int b)
		{
			int A = a;
			int B = b;
			int C = A*B;
			String stringC = String.valueOf(C);
			showToast(stringC);
		}
		
		@JavascriptInterface
		public void calcDivide(int a, int b)
		{
			int A = a;
			int B = b;
			double C = A/B;
			String stringC = String.valueOf(C);
			showToast(stringC);
		}
		
		public void setit(){
			
		}
		
		public void answerActivityFunction() {
			Intent next = new Intent(_context, answerActivity.class);
			//next.putExtra("ANSWER", answer);  // Pass Current Zip Location
			startActivity(next);
			
		}
	
	}
}