package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShoppingCartActivity extends AppCompatActivity implements LoginContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void result(Account account) {

    }
}