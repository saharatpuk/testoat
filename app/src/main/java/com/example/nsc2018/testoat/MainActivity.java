package com.example.nsc2018.testoat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nsc2018.testoat.db.DbHelper;
import com.example.nsc2018.testoat.model.Main2Activity;

public class MainActivity extends AppCompatActivity {

    private DbHelper mdbHelper;
    private SQLiteDatabase mDb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cracker(View view) {

        mdbHelper = new DbHelper(this);
        mDb = mdbHelper.getReadableDatabase();

        final Context context = getApplicationContext();
        final EditText usre = findViewById(R.id.editUser);
        final EditText pass = findViewById(R.id.editPass);
        Button kod = findViewById(R.id.Login);


                if (mdbHelper.check(usre.getText().toString(), pass.getText().toString())) {


                    Toast toast = Toast.makeText(context, "YES", Toast.LENGTH_SHORT);
                    toast.show();


                } else {
                    Toast toast = Toast.makeText(context, "NO", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }



    }



