package com.example.homer.sda_2018_assign2matthewbrennan;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Mail_Data extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail__data);
    }
    /** Called when the user taps the SEND button to send the three strings of data to MainActivity and resumes the MainActivity*/
    public void returnMailData(View view) {
        //The following sets the string from the 'To' textfield in 'string_to' and sends it to the Main Activity
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText_to = (EditText) findViewById(R.id.editText);
        String message_to = editText_to.getText().toString();
        intent.putExtra("string_to", message_to);

        //The following sets the string from the 'Subject' textfield in 'string_subject' and sends it to the Main Activity
        EditText editText_subject = (EditText) findViewById(R.id.editText2);
        String message_subject = editText_subject.getText().toString();
        intent.putExtra("string_subject", message_subject);

        //The following sets the string from the 'Compose' textfield in 'string_compose' and sends it to the Main Activity
        EditText editText_compose = (EditText) findViewById(R.id.editText3);
        String message_compose = editText_compose.getText().toString();
        intent.putExtra("string_compose", message_compose);
        startActivity(intent);
    }
}
