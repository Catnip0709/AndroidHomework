package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import java.lang.String;
import android.widget.ProgressBar;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Vector usr = new Vector();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("HOMEWORK-2");
        usr.add("susan");
        usr.add("sam");

        //监听用户名输入框
        EditText name = (EditText) findViewById(R.id.text_cin_usrname);
        name.addTextChangedListener(new TextWatcher() {
            @Override   public void beforeTextChanged(CharSequence s, int start, int count, int after) {  }
            @Override   public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) { //屏蔽回车 中英文空格
                String name1=s.toString();
                int usr_size=usr.size();
                boolean flag=false;
                for(int i=0;i<usr_size;i++) {
                    if (name1.equals(usr.elementAt(i))) {
                        TextView name = (TextView) findViewById(R.id.text_usrname);
                        name.setText("illegel name ×");
                        add();
                        flag = true;
                    }
                }
                if(flag==false) {
                    if (!name1.isEmpty()) {
                        TextView name = (TextView) findViewById(R.id.text_usrname);
                        name.setText("Usr name √");
                        add();
                    } else {
                        TextView name = (TextView) findViewById(R.id.text_usrname);
                        name.setText("cannot be NULL ×");
                        add();
                    }
                }
            }
        });

        //监听密码输入
        EditText password = (EditText) findViewById(R.id.text_cin_password);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) { //屏蔽回车 中英文空格
                String psw=s.toString();
                if(psw.length()>=4) {
                    TextView name= (TextView) findViewById(R.id.text_password);
                    name.setText("Password √");
                    add();
                }
                else
                {
                    TextView name= (TextView) findViewById(R.id.text_password);
                    name.setText("too short ×");
                    add();
                }
            }
        });
    };

    public void onClick_btn(View v)
    {
        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        if(bar.getProgress()==100) {
            Toast.makeText(v.getContext(), "Register successful!", Toast.LENGTH_LONG).show();
            TextView name= (TextView) findViewById(R.id.text_cin_usrname);
            String name_copy=name.toString();
            usr.add(name_copy);
            name.setText("");
            TextView psw= (TextView) findViewById(R.id.text_cin_password);
            psw.setText("");
            TextView spr= (TextView) findViewById(R.id.text_surprise);
            spr.setText("");
            TextView name_left= (TextView) findViewById(R.id.text_usrname);
            name_left.setText("User_name");
            TextView psw_left= (TextView) findViewById(R.id.text_password);
            psw_left.setText("Password");
            RadioGroup sexual=(RadioGroup)findViewById(R.id.radioGroup);
            sexual.clearCheck();
            bar.setProgress(0);
        }
        else
            Toast.makeText(v.getContext(), "Register failed!",Toast.LENGTH_LONG).show();
    }

    public void onClick_male(View v)
    {
        TextView name= (TextView) findViewById(R.id.text_surprise);
        name.setText("hello handsome.");
        ProgressBar bar=(ProgressBar)findViewById(R.id.progressBar);
        add();
        if(bar.getProgress()==60)
            bar.setProgress(100);
    }

    public void onClick_female(View v)
    {
        TextView name= (TextView) findViewById(R.id.text_surprise);
        name.setText("hello beauty.");
        ProgressBar bar=(ProgressBar)findViewById(R.id.progressBar);
        add();
        if(bar.getProgress()==60)
            bar.setProgress(100);
    }

    public void add() {
        int sum = 0;

        TextView usrname = (TextView) findViewById(R.id.text_usrname);
        String usrname_copy = usrname.getText().toString();
        if (usrname_copy.equals("Usr name √"))
            sum += 30;

        TextView psw = (TextView) findViewById(R.id.text_password);
        String psw_copy = psw.getText().toString();
        if (psw_copy.equals("Password √"))
            sum += 30;

        TextView surprise = (TextView) findViewById(R.id.text_surprise);
        String surprise_copy = surprise.getText().toString();
        if (surprise_copy.equals("hello handsome.") || surprise_copy.equals("hello beauty."))
            sum += 40;

        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setProgress(sum);
    }


}



