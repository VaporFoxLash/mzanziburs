package com.radebe.mzanzibursaries;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private WebView webview;
    private Toolbar toolbar;
//    private Spinner spinner;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main2);

        toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
//        spinner = findViewById(R.id.spinner);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
//                R.layout.spinner_item, getResources().getStringArray(android.R.array.emailAddressTypes));
//        spinner.setAdapter(adapter);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        webview = findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new MainActivity2.Callback());
        String website = getIntent().getStringExtra("website");
        webview.loadUrl(website);
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
        Bundle mBundle = new Bundle();
        ArrayList otherOpportunities = new ArrayList();
        otherOpportunities.add("");
        int id = item.getItemId();
        if(id == R.id.share) {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_TEXT, webview.getContext().toString());
            startActivity(Intent.createChooser(i, "Share to"));
            return true;
        } else if(id == R.id.refresh) {
            webview.reload();
            return true;
        }else if(id == R.id.other) {
            intent.putExtra("website", "https://www.wethinkcode.co.za/");
            intent.putExtras(mBundle);
            startActivity(intent);
            return true;
        } else if(id == R.id.privacy_policy) {
            createNewDialog("We don't collect any personal data or application profiles sent to listed sources.\n" +
                    "We also do not share any data with third parties.\n" +
                    "\n" +
                    "Third parties are allowed to show ads and may collect anonymous information when you use the app.\n" +
                    "No personalised ads based on sensitive categories, such as race, religion, sexual orientation or health.");
            return true;
        }else if(id == R.id.about) {
            createNewDialog("We collected useful sites to spare you countless hours searching for funding on the internet.\n" +
                    "Contact us to get your website removed.");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void createNewDialog(String text){
        dialogBuilder = new AlertDialog.Builder(this);
        final View window = getLayoutInflater().inflate(R.layout.popup_window, null);
        popupWindow = window.findViewById(R.id.pop_text);
        popupWindow.setText(text);
        TextView textView = window.findViewById(R.id.copyrigtstxt);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_copyright_24, 0, 0, 0);
        dialogBuilder.setView(window);
        dialog = dialogBuilder.create();
        dialog.show();
    }
}