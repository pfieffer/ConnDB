package np.com.ravi.dbconn;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

import np.com.ravi.dbconn.app.AppController;

public class NewProductActivity extends AppCompatActivity {

    private EditText inputName, inputPrice, inputDesc;
    private Button btnAddProduct;
    private ProgressDialog pDialog;

    private String urlForAddingProduct = AppController.baseUrl+"create_product.php";
    private static String TAG = NewProductActivity.class.getSimpleName();

    String name, price, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        inputName = (EditText) findViewById(R.id.edt_product_name);
        inputPrice = (EditText) findViewById(R.id.edt_product_price);
        inputDesc = (EditText) findViewById(R.id.edt_product_description);

        btnAddProduct = (Button) findViewById(R.id.btn_add_product);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Adding the product to our database");
        pDialog.setCancelable(false);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    addNewProductToDatabase();
                }

            }
        });
    }

    private boolean validate() {

        name = inputName.getText().toString();
        price = inputPrice.getText().toString();
        description = inputDesc.getText().toString();

        if (name.length() == 0 ) {
            inputName.setError("Please enter correct name for the product.");
            return false;
        } else if(price.length()==0){
            inputPrice.setError("Please enter correct price for the product.");
            return false;
        } else if (description.length() == 0){
            inputDesc.setError("Please enter a short description for the product");
            return false;
        }
        else{
            return true;
        }
    }

    private void addNewProductToDatabase(){

        showpDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlForAddingProduct,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        resetFields();
                        hidepDialog();
                        Toast.makeText(NewProductActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hidepDialog();
                        Toast.makeText(NewProductActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("name",name);
                params.put("price",price);
                params.put("description", description);
                return params;
            }
        };
        AppController.getmInstance().addToRequestQueue(stringRequest);

    }

    private void resetFields() {
        inputName.setText("");
        inputDesc.setText("");
        inputPrice.setText("");
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
