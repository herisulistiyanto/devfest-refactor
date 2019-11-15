package com.google.devfest.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.devfest.R;
import com.google.devfest.model.Customer;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvName;
    private Button btnRandom;

    private ArrayList<Customer> customers = new ArrayList<Customer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customers.add(new Customer("Heri", "Sulis"));
        customers.add(new Customer("Fikri", null));
        customers.add(new Customer("Didik", ""));

        tvName = findViewById(R.id.tv_name);
        btnRandom = findViewById(R.id.btn_random);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = randomNameFromModel(customers);
                tvName.setText(name);
            }
        });

    }

    private String randomNameFromModel(ArrayList<Customer> listCustomer) {
        Random random = new Random();
        Customer customer = listCustomer.get(random.nextInt(listCustomer.size()));
        final String firstName = customer.getFirstName();
        final String lastName = (TextUtils.isEmpty(customer.getLastName())) ? "Unknown" : customer.getLastName();
        return firstName + " " + lastName;
    }

}
