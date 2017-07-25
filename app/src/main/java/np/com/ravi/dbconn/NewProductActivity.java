package np.com.ravi.dbconn;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewProductActivity extends AppCompatActivity {

    private EditText name, price, description;
    private Button btnAddProduct;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        name = (EditText) findViewById(R.id.edt_product_name);
        price = (EditText) findViewById(R.id.edt_product_price);
        description = (EditText) findViewById(R.id.edt_product_description);

        btnAddProduct = (Button) findViewById(R.id.btn_add_product);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Adding the product to our database");
        pDialog.setCancelable(false);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewProductToDatabase();
            }
        });
    }

    private void addNewProductToDatabase() {
        // run php script to add the product. use volley. see history on the remote github for guidance.

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
