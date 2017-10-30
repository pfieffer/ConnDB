package np.com.ravi.dbconn.app;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue; //volley.jar lai libs folder vitra paste garera, import as library gareko
import com.android.volley.toolbox.Volley;

/**
 * Created by ravi on 7/20/17.
 */

//this is a singleton class where we initialize all volley core objects
public class AppController extends Application{
    public static final String TAG = AppController.class.getSimpleName();

    private RequestQueue mRequestQueue;

    private static AppController mInstance;

    public static String baseUrl= "https://afferent-employee.000webhostapp.com/androidTest/";

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getmInstance(){
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag){
        if(mRequestQueue != null){
            mRequestQueue.cancelAll(tag);
        }
    }

}