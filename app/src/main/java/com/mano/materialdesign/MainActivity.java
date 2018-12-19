package com.mano.materialdesign;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText Edit_name , Edit_roll_no, Edit_fathername, Edit_mark;
    Button submit;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edit_name = findViewById(R.id.reg_fullname);
        Edit_roll_no = findViewById(R.id.roll_no);
        Edit_fathername = findViewById(R.id.father_name);
        Edit_mark= findViewById(R.id.mark);

        submit = findViewById(R.id.btnSubmit);

        db = new DatabaseHelper(this);
        Adddata();

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//        }
//        else {
//        }


    }

    public void Adddata(){
     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String name = Edit_name.getText().toString();
             String roll_no = Edit_roll_no.getText().toString();
             String father_name = Edit_fathername.getText().toString();
             String mark = Edit_mark.getText().toString();
          boolean inserted =   db.insertData(name,roll_no,father_name,mark);
             if (inserted == true)
                 Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
             else
                 Toast.makeText(MainActivity.this,"Data Not Inserted", Toast.LENGTH_LONG).show();
         }
     });
    }
}
