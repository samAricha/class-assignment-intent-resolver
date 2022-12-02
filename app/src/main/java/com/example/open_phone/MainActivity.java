package com.example.open_phone;

// importing packages
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState)    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.progress);

        Button startBrowser = findViewById(R.id.start_browser);
        progress.setVisibility(View.GONE);
        startBrowser.setOnClickListener(view -> {
            progress.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Directing You to the URL", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tum.ac.ke"));
            startActivity(i); });



    }


    @Override
    public void onBackPressed() {
        progress.setVisibility(View.INVISIBLE);
        super.onBackPressed();

    }

    // This function is called when button is clicked.
    public void Call(View v)
    {
        // Find the EditText by its unique ID
        TextInputLayout e = findViewById(R.id.editText);


        Toast.makeText(this, "clicked", Toast.LENGTH_LONG)
                .show();

        // Use format with "tel:" and phoneNumber created is
        // stored in u.
        Uri u = Uri.parse("tel:" + e.getEditText().getText().toString());

        // Create the intent and set the data for the
        // intent as the phone number.
        Intent i = new Intent(Intent.ACTION_DIAL, u);

        try
        {
            // Launch the Phone app's dialer with a phone
            // number to dial a call.
            startActivity(i);
        }
        catch (SecurityException s)
        {
            // show() method display the toast with
            // exception message.
            Toast.makeText(this, "An error occurred", Toast.LENGTH_LONG)
                    .show();
        }
    }
}
