package np.com.ravi.dbconn;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import np.com.ravi.dbconn.app.AppController;

import static com.android.volley.VolleyLog.TAG;

public class MainActivity extends AppCompatActivity {

    Button btnViewProducts;
    Button btnNewProduct;

    //json object response url
    private String urlForJsonObject = "http://10.0.0.139/androidTest/get_all_products.php?pid=1"; //?pid=1

    private static String TAG = MainActivity.class.getSimpleName();

    //progress dialog
    private ProgressDialog pDialog;

    private TextView txtResponse;

    //temporary string to show the parsed response
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnViewProducts = (Button) findViewById(R.id.btnViewProducts);
        btnNewProduct = (Button) findViewById(R.id.btnCreateProduct);

        txtResponse = (TextView)findViewById(R.id.product_textview);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please Wait....");
        pDialog.setCancelable(false);

        btnViewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjectRequest();
            }
        });


        btnNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), NewProductActivity.class);
//                startActivity(intent);
            }
        });
    }

    private void makeJsonObjectRequest() {

        showpDialog(); //showing progress dialog while json oject is being fetched

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
                            JSONArray product = response.getJSONArray("product");
                            JSONObject phone = product.getJSONObject(0);
                            String name = phone.get("name").toString();
                            String price = phone.get("price").toString();
                            String description = phone.get("description").toString();
                            jsonResponse = "";
                            jsonResponse += "Name: " + name + "\n\n";
                            jsonResponse += "Price: " + price + "\n\n";
                            jsonResponse += "Description: " + description + "\n\n";

                            txtResponse.setText(jsonResponse);

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


