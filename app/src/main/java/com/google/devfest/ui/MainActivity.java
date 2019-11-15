package com.google.devfest.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.devfest.R;
import com.google.devfest.repo.CustomerRepo;

public class MainActivity extends AppCompatActivity {

    private TextView tvName;
    private Button btnRandom;

    private CustomerRepo customerRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customerRepo = CustomerRepo.getInstance();

        tvName = findViewById(R.id.tv_name);
        btnRandom = findViewById(R.id.btn_random);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = customerRepo.getFormattedName();
                tvName.setText(name);
            }
        });

    }

}
