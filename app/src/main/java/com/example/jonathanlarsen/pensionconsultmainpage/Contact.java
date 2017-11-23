package com.example.jonathanlarsen.pensionconsultmainpage;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Contact extends Activity {

    // Initiate spinner variables
    Spinner mySpinner;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Spinner
        mySpinner = (Spinner) findViewById(R.id.spinner);
        myAdapter = new ArrayAdapter<String>(Contact.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.contact_subjects));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
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

    /*
    // Check to see if the phone number is actually a phone number (Cannot contain +45 (atm)
    public boolean isPhoneNumber(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }*/

    public void sendMessage(View view) {
        // Get variables from editable text
        // Name
        EditText etName = (EditText) findViewById(R.id.etName);
        String name = etName.getText().toString();
        // phone number
        EditText etPhone = (EditText) findViewById(R.id.etPhone);
        String phone = etPhone.getText().toString();
        // Mail
        EditText etMail = (EditText) findViewById(R.id.etMail);
        String mail = etMail.getText().toString();
        // Spinner
        String test = mySpinner.getSelectedItem().toString();
        EditText etComment = (EditText) findViewById(R.id.etComment);
        String comment = etComment.getText().toString();

        // Validate name
        if(isAlpha(name)) {
            // Name is validated
        }else {
            // Name is not validated
        }

        /*
        // Validate phone number
        if(isPhoneNumber(phone)) {
            // Phone is validated to contain numbers only
        }else {
            // Phone is not validated
        }*/


    }
}

