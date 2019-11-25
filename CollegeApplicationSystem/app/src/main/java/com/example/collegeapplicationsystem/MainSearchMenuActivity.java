package com.example.collegeapplicationsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainSearchMenuActivity extends AppCompatActivity {
    private static final String TAG = "Query";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private String nameSearchText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_search);
    }

    public void openAccountView(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewAccountActivity.class);
        startActivity(intent);
    }

    public void openNameSearchInput(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
        builder.setTitle("College Name Search");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("SEARCH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nameSearchText = input.getText().toString();
                Intent intent = new Intent(getApplicationContext(), CollegeNameSearchActivity.class);
                intent.putExtra("nameSearch", nameSearchText);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


}
