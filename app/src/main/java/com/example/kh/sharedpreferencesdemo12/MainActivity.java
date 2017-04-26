package com.example.kh.sharedpreferencesdemo12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kh.sharedpreferencesdemo12.ViewHolder.main_activity;

public class MainActivity extends AppCompatActivity {
    com.example.kh.sharedpreferencesdemo12.ViewHolder.main_activity holder ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        holder = new main_activity();
        holder.etName = (EditText) findViewById(R.id.etname);
        holder.etData = (EditText) findViewById(R.id.etData);
        holder.btnDelete = (Button) findViewById(R.id.btnDelete);
        holder.btnSharedPreferences = (Button) findViewById(R.id.btnSharedPreferences);
        holder.btnShowData =(Button) findViewById(R.id.btnShowData);
        holder.btnShowAll = (Button) findViewById(R.id.btnShowAll);
        holder.txtShowData =(TextView) findViewById(R.id.txtData);
        holder.btnShowData.setOnClickListener(onclicklistener);
        holder.btnSharedPreferences.setOnClickListener(onclicklistener);
        holder.btnDelete.setOnClickListener(onclicklistener);
        holder.btnShowAll.setOnClickListener(onclicklistener);
    }
    private View.OnClickListener onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnSharedPreferences:
                    com.example.kh.sharedpreferencesdemo12.Module.
                            SharedPreferenceshelper.getInstance().setData(MainActivity.this,holder.etName.getText().toString().trim(),holder.etData.getText().
                            toString().trim());
                    break;
                case R.id.btnShowData:
                   String data= com.example.kh.sharedpreferencesdemo12.Module.SharedPreferenceshelper.
                           getInstance().getData(MainActivity.this,holder.etName.getText().toString().trim());
                   holder.txtShowData.setText(data);

                    break;
                case R.id.btnDelete:
                    com.example.kh.sharedpreferencesdemo12.Module.SharedPreferenceshelper.getInstance().
                            deleteData(MainActivity.this,holder.etName.getText().toString().trim());
                case R.id.btnShowAll:
                 String alldata=   com.example.kh.sharedpreferencesdemo12.Module.SharedPreferenceshelper.getInstance().getAllData(MainActivity.this);
                    Toast.makeText(MainActivity.this, alldata, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}
