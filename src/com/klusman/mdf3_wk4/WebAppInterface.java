package com.klusman.mdf3_wk4;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;


public class WebAppInterface extends Activity{
	
    Context _context;
    int answer;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context context) {
    	_context = context;
    }

    
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(_context, toast, Toast.LENGTH_SHORT).show();
       // answerActivityFunction();
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
		
			
		Log.i("TEST","TEST");
		Intent next = new Intent(_context, answerActivity.class);
		//next.putExtra("ANSWER", answer);  // Pass Current Zip Location
		this.startActivity(next);
		
	}
    
    
}
