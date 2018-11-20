package com.example.homer.sda_2018_assign2matthewbrennan;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override  // Standard creation of the MainActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        //The first time when I run the android application, the intent will be empty because the second activity is not yet called, so I get a null exception  (Java null pointer exception).
        Intent intent = this.getIntent();
        //If there is a non null return then this Activity was called by the second Activity an dw eneed to execute the code that populates the 4th TextView and activates the SEND Button
        if( getIntent().getExtras() != null){
            // The following gets the 3 strings of information from second Activity
            final String message_to = intent.getStringExtra("string_to");
            final String message_subject = intent.getStringExtra("string_subject");
            final String message_compose = intent.getStringExtra("string_compose");
            //The following sets then 4th textView on this Activity(named textView5) to textView
            TextView textView = findViewById(R.id.textView5);
            //The following then sends the data from the 2nd Activity to the 4th textView on this Activity
            textView.setText("To: " + message_to + "\n" + "Subject: " + message_subject + "\n" + "Compose: " + message_compose);
            // Th efollowing initialises the SEND Button on the MainActivity
            Button buttonMail = findViewById(R.id.button);
            // The following set a listener on thei Button
             buttonMail.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                //The following sets the Intent when the SEND button has been pressed  which activated an E-mail application
                Intent email = new Intent(Intent.ACTION_SEND);
                //The following lines sends the 3 strings of data with teh Intent
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{message_to});
                email.putExtra(Intent.EXTRA_SUBJECT, message_subject);
                email.putExtra(Intent.EXTRA_TEXT, message_compose);
                 //need this to prompts email client only
                 email.setType("message/rfc822");
                 //The following allows for different E-mail clients been available
                startActivity(Intent.createChooser(email, "Choose E-mail client :"));
                  }
              });
        }
    }

    /** Called when the user taps the 'Implicit Intent: Open camera' text field */
    public void launchCamera(View view) {
        Intent camera_intent;
        camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(camera_intent);
    }
    /** Called when the user taps the 'Implicit Intent: View Picture' text field */
    public void viewPicture(View view) {
       // Uri uri =  Uri.fromFile(entry);
        Intent camera_intent;
        camera_intent = new Intent(android.content.Intent.ACTION_VIEW);
        camera_intent.setDataAndType(Uri.parse("file://" + "/sdcard/test.jpg"), "image/*");
        startActivity(camera_intent);
    }
    /** Called when the user taps the Send button from the main Activity */
    public void goto_mailData(View view) {
        Intent intent = new Intent(this, Mail_Data.class);
        startActivity(intent);
    }
}
