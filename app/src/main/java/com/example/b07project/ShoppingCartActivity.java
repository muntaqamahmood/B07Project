package com.example.b07project;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
    private Customer customer;
    private StoreOwner storeOwner;
    private CustomerOrder order;
    private ArrayList<Product> products = new ArrayList<Product>();
    private ListView lstView;
    private Button orderBtn;
    private TextView productName, productBrand, productPrice;

    private String state = "Normal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        customer = (Customer) getIntent().getSerializableExtra(Resources.getSystem().getString(R.string.customer));
        storeOwner = (StoreOwner)getIntent().getSerializableExtra(Resources.getSystem().getString(R.string.store_owner));
        order = (CustomerOrder) getIntent().getSerializableExtra("order");
        productName = (TextView)findViewById(R.id.txtProductName);
        productBrand = (TextView)findViewById(R.id.txtBrandName);
        productPrice = (TextView)findViewById(R.id.txtPrice);

        ArrayAdapter<Product> productsAdapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1);
        lstView = findViewById(R.id.cartListView);
        lstView.setAdapter(productsAdapter);
        if(order.items != null){
            for(Product p: order.items){
                productsAdapter.add(p);
            }
        }
        orderBtn = (Button)findViewById(R.id.orderButton);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(state.equals("Order successful!")||state.equals("Order ready for pickup!")){
                    Toast.makeText(ShoppingCartActivity.this, "You can now pick up your order", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

   /* private void addedToCart(){
        final DatabaseReference refToCartList = FirebaseDatabase.getInstance().getReference().child("Cart List");
        final HashMap<String, Object>cartMap = new HashMap<>();
        cartMap.put("name", productName.getText().toString());
        cartMap.put("brand", productBrand.getText().toString());
        cartMap.put("price", productPrice.getText().toString());
        //cartMap.put("orderNumber", productOrderNumber);

        refToCartList.child("Customer view").child(customer.getUsername()).child("Products").child(productOrderNumber).updateChildren(cartMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    refToCartList.child("")
                }
            }
        });

    }*/





    private void getProductDetails(){

    }
}