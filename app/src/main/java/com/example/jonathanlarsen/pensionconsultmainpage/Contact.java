package com.example.jonathanlarsen.pensionconsultmainpage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import javax.security.auth.Subject;

public class Contact extends Activity implements View.OnClickListener {

    private Button sendButton;

    private String name, mail, subject, comment;

    // Initiate spinner variables
    Spinner mySpinner;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        sendButton = (Button) findViewById(R.id.button2);

        mySpinner = (Spinner) findViewById(R.id.spinner);
        myAdapter = new ArrayAdapter<String>(Contact.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.contact_subjects));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        startLayout();

    }

    public void onClick (View view) {
        if (view == sendButton) {
            sendMessage(view);
        }
    }

    public void startLayout () {
        sendButton.setOnClickListener(this);
    }

    // verify that String only contain letters
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public void sendMessage(View view) {
        // Get variables from editable text
        // Name
        EditText etName = (EditText) findViewById(R.id.etName);
        name = etName.getText().toString();
        // Sender email
        EditText etSubject = (EditText) findViewById(R.id.etMail);
        mail = etSubject.getText().toString();
        // Spinner
        subject = mySpinner.getSelectedItem().toString();
        // Comment
        EditText etComment = (EditText) findViewById(R.id.etComment);
        comment = etComment.getText().toString();

        validation();

        /* Create the Intent */
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        /* Fill it with Data */
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"jakobsen1608@hotmail.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject:" + subject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Comment: " + comment + "From: " + name + " Mail: " + mail);

        /* Send it off to the Activity-Chooser */
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));


    }

    public Boolean validation () {
        // Validate name
        if(isAlpha(name)) {
            // Validate subject
            if(subject != null) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {    }
}

