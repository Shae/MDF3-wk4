package com.klusman.mdf3_wk4;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;


public class WebAppInterface {
    Context _context;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context context) {
    	_context = context;
    }

    
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(_context, toast, Toast.LENGTH_SHORT).show();
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
}
