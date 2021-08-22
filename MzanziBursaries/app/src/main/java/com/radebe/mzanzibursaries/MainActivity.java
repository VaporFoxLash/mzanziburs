 package com.radebe.mzanzibursaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     Toolbar toolbar;
     BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        toolbar = findViewById(R.id.toolbar);
//        toolbar.setText
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);;

        Button btn_nsfas = findViewById(R.id.nsfas);
        Button btn_teaching = findViewById(R.id.teaching);
        Button btn_medicine = findViewById(R.id.medicine);
        Button btn_science = findViewById(R.id.science);
        Button btn_engineering = findViewById(R.id.engineering);
        Button btn_law = findViewById(R.id.law);
        Button btn_dhet = findViewById(R.id.dhet);
        Button btn_commerce = findViewById(R.id.commerce);
        Button btn_aps = findViewById(R.id.btnAPS);
        Button btn_learnership = findViewById(R.id.btnLearnerships);

        btn_nsfas.setOnClickListener(this);
        btn_teaching.setOnClickListener(this);
        btn_medicine.setOnClickListener(this);
        btn_science.setOnClickListener(this);
        btn_engineering.setOnClickListener(this);
        btn_law.setOnClickListener(this);
        btn_dhet.setOnClickListener(this);
        btn_commerce.setOnClickListener(this);
        btn_aps.setOnClickListener(this);
        btn_learnership.setOnClickListener(this);

    }

    public void openPage(String url){
        /* An intent to launch a webview activity
         * All website are shown on this activity
         */
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        Bundle mBundle = new Bundle();
        intent.putExtra("website", url);
        intent.putExtras(mBundle);
        startActivity(intent);
    }

     @Override
     public void onClick(View v) {
         /* OnClick method
          * Calls openPage method to open a mentioned page
          */

         switch (v.getId()) {
             case R.id.nsfas:
                 openPage("https://www.nsfas.org.za");
                 break;
             case R.id.teaching:
                 openPage("https://www.bursariesportal.co.za/bursary-category/teaching");
                 break;
             case R.id.medicine:
                 openPage("https://southafricalists.com/bursaries-for-medicine/");
                 break;
             case R.id.science:
                 openPage("https://bursariesinfo.co.za/2021-Bursaries/science-bursaries-2021-2022/");
                 break;
             case R.id.engineering:
                 openPage("https://www.zabursaries.co.za/engineering-bursaries-south-africa/");
                 break;
             case R.id.law:
                 openPage("https://safacts.co.za/list-of-law-bursaries-in-south-africa/");
                 break;
             case R.id.dhet:
                 openPage("http://www.internationalscholarships.dhet.gov.za/index.php/scholarships/available-scholarships");
                 break;
             case R.id.commerce:
                 openPage("https://bursaries-southafrica.co.za/bursaries-for-commerce/");
                 break;
         }
     }

 }