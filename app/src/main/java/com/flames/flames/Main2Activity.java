package com.flames.flames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Scanner;

public class Main2Activity extends AppCompatActivity {

    private EditText name1, name2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name1 = (EditText) findViewById(R.id.name1);
        name2 = (EditText) findViewById(R.id.name2);
        Button bt = (Button) findViewById(R.id.calc);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = name1.getText().toString();
                String n2 = name2.getText().toString();
                String res;
                res = CalculateFlame(n1, n2);
                Intent startintent = new Intent(Main2Activity.this, Main3Activity.class);
                startintent.putExtra("n1",n1);
                startintent.putExtra("n2",n2);
                startintent.putExtra("res",res);
                startActivity(startintent);
            }
        });
    }

    public String CalculateFlame(String n1, String n2) {
        int m;

        String first=n1;
        String second=n2;
        StringBuffer s1=new StringBuffer(first);
        StringBuffer s2=new StringBuffer(second);
        int a=s1.length();
        int b=s2.length();

        //comparing two names
        label: for(int i=0;i<a;i++)
        {
            char c=s1.charAt(i);
            //	System.out.println(c);
            for(int j=0;j<b;j++)
            {
                char d=s2.charAt(j);
                if(c==d)
                {
                    ////k++;
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(j);
                    ////System.out.println(s1 +" " +s2);
                    a=s1.length();
                    //m=a;
                    b=s2.length();
                    i=0;
                    j=0;
                    // continue label;
                }
            }

            ////	System.out.println(k);
        }
        int d=(a+b);
        //int n=-1,l=0,p=0;
        StringBuffer s3=new StringBuffer("flames");
        String s4=new String();

        label1:	for(int i=0;i<5;i++)
        {int n=-1,l=0,p=0;
            for(int j=1;j<=d;j++)
            {
                n++;
                l++;
                //int p=0;
                if(n>s3.length()-1)
                {
                    char e=s3.charAt(p);
                    if(l==d)
                    {
                        s3.deleteCharAt(p);
                        //String s4=new String();
                        s4=s3.substring(p,s3.length());
                        ////System.out.println(s4);
                        s3.delete(p,s3.length());
                        ////System.out.println(s3);
                        s3.insert(0,s4);
                        ////System.out.println(s3);
                        break;
                    }
                    else{ p++;
                        if(p==s3.length())
                        {p=0;
                        }
                    }
                }
                else
                {
                    char e=s3.charAt(n);
                    if(l==d)
                    {
                        s3.deleteCharAt(n);

                        s4=s3.substring(n,s3.length());
                        ////System.out.println(s4);
                        s3.delete(n,s3.length());
                        ////System.out.println(s3);
                        s3.insert(0,s4);
                        ////System.out.println(s3);
                        break;
                    }
                    //break;
                }

            }
        }
        ////System.out.println(s3);
        char result=s3.charAt(0);
        String result1;
        switch (result) {
            case 'f':
                result1 = "FRIENDS";
                break;
            case 'l':
                result1 = "LOVE";
                break;
            case 'a':
                result1 = "AFFECTION";
                break;
            case 'm':
                result1 = "MARRIAGE";
                break;
            case 'e':
                result1 = "ENEMY";
                break;
            case 's':
                result1 = "SISTER";
                break;
            default:
                result1="NO MATCH";
        }

        return result1;
    }
}