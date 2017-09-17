package doganevci.appchooser.JSBridge;

import android.content.Context;
import android.os.Vibrator;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by doganevci on 16/09/2017.
 */

public class JSBridge {
    Context mContext;
    WebView _webView;

    /** Instantiate the interface and set the context */
    public JSBridge(Context c, WebView webView) {
        mContext = c;
        _webView=webView;
    }
    @JavascriptInterface
    public void vibrateAndShowToast() {


        Vibrator v = (Vibrator)mContext.getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 1 seconds
        v.vibrate(1000);
        Toast.makeText(mContext, "TESTtest", Toast.LENGTH_SHORT).show();

    }


}
