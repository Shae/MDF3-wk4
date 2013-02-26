package com.klusman.mdf3_wk4;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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
    

    

////////////////// WEB INTERFACE /////////////////////
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
		
//		public void setInfo(){
//			
//			switch (webview.getId()) {
//			case R.id.btn1:
//				
//				break;
//			case R.id.btn2:
//							
//				break;
//			case R.id.btn3:
//				
//				break;
//			case R.id.btn4:
//				
//				break;
//			case R.id.btn5:
//				
//				break;
//			case R.id.btn6:
//				
//				break;
//			case R.id.btn7:
//				
//				break;
//			case R.id.btn8:
//				
//				break;
//			case R.id.btn9:
//				
//				break;
//			case R.id.btn0:
//				
//				break;
//			default:
//				break;
//			}
//			
//		}// END setinfo
	
	}  //  END Class
}  // END MAINACTIVITY