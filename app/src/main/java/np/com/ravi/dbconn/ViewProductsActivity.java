package np.com.ravi.dbconn;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import np.com.ravi.dbconn.app.AppController;

public class ViewProductsActivity extends AppCompatActivity {
    //json object response url
    private String urlForJsonObject = "http://10.0.0.139/androidTest/get_all_products.php";

    private static String TAG = MainActivity.class.getSimpleName();

    //progress dialog
    private ProgressDialog pDialog;

    private TextView txtResponse;

    private ListView productsList;

    //temporary string to show the parsed response
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);
        
        productsList = (ListView) findViewById(R.id.listview_all_products);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please Wait....");
        pDialog.setCancelable(false);


        makeJsonObjectRequest();


    }

    private void makeJsonObjectRequest() {

        showpDialog(); //showing progress dialog while json oject is being fetched

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        final List<String> productsArrayList = new ArrayList<String>();


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlForJsonObject,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString()); //for android log cat??

                        try {
                            // Parsing json object response
                            // response will be a json object
                            int success = response.getInt("success");
                            if (success == 1){
                                JSONArray products = response.getJSONArray("products");
                                for(int i =0; i<products.length(); i++){
                                    JSONObject phone = products.getJSONObject(i);
                                    String name = phone.get("name").toString();
                                    String price = phone.get("price").toString();
                                    String description = phone.get("description").toString();
                                    jsonResponse = "";
                                    jsonResponse += "Name: " + name + "\n\n";
                                    jsonResponse += "Price: " + price + "\n\n";
                                    jsonResponse += "Description: " + description + "\n\n";
                                    productsArrayList.add(jsonResponse);


                                    //txtResponse.setText(jsonResponse);
                                }
                                // This is the array adapter, it takes the context of the activity as a
                                // first parameter, the type of list view as a second parameter and your
                                // array as a third parameter.
                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                                        ViewProductsActivity.this,
                                        android.R.layout.simple_list_item_1,
                                        productsArrayList );

                                productsList.setAdapter(arrayAdapter);
                            }
                            else {
                                Toast.makeText(ViewProductsActivity.this, "No products in the database", Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        hidepDialog(); //hide the dialog after the JSON object is loaded

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d(TAG,"Error: "+ volleyError.getMessage() );
                Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog(); //hide the progress dialog
            }
        });

        //adding request to request queue
        AppController.getmInstance().addToRequestQueue(jsonObjReq);
    }



    private void showpDialog(){
        if(!pDialog.isShowing()){
            pDialog.show();
        }
    }

    private void hidepDialog(){
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
    }
}
