package com.example.b3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgLB1;
    ImageView imgLB2;
    ImageView imgLB3;
    Button btnLatBai;
    Button btnPA;
    TextView txtScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl(){
        imgLB1 = (ImageView)findViewById(R.id.imageViewLB1);
        imgLB2 = (ImageView)findViewById(R.id.imageViewLB2);
        imgLB3 = (ImageView)findViewById(R.id.imageViewLB3);
        btnLatBai = (Button)findViewById(R.id.buttonLB);
        btnPA = (Button)findViewById(R.id.buttonPlayAgain);
        txtScore = (TextView)findViewById(R.id.Score);
    }
    private void setEvent(){
        btnPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgLB1.setImageResource(R.drawable.b1fv);
                imgLB2.setImageResource(R.drawable.b1fv);
                imgLB3.setImageResource(R.drawable.b1fv);
                txtScore.setText("SCORE");
            }
        });
        btnLatBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> MLB = new ArrayList<Integer>();
                MLB.add(R.drawable.c1);
                MLB.add(R.drawable.c2);
                MLB.add(R.drawable.c3);
                MLB.add(R.drawable.c4);
                MLB.add(R.drawable.c5);
                MLB.add(R.drawable.c6);
                MLB.add(R.drawable.c7);
                MLB.add(R.drawable.c8);
                MLB.add(R.drawable.c9);
                MLB.add(R.drawable.c10);
                MLB.add(R.drawable.cj);
                MLB.add(R.drawable.cq);
                MLB.add(R.drawable.ck);

                MLB.add(R.drawable.s1);
                MLB.add(R.drawable.s2);
                MLB.add(R.drawable.s3);
                MLB.add(R.drawable.s4);
                MLB.add(R.drawable.s5);
                MLB.add(R.drawable.s6);
                MLB.add(R.drawable.s7);
                MLB.add(R.drawable.s8);
                MLB.add(R.drawable.s9);
                MLB.add(R.drawable.s10);
                MLB.add(R.drawable.sj);
                MLB.add(R.drawable.sq);
                MLB.add(R.drawable.sk);

                MLB.add(R.drawable.h1);
                MLB.add(R.drawable.h2);
                MLB.add(R.drawable.h3);
                MLB.add(R.drawable.h4);
                MLB.add(R.drawable.h5);
                MLB.add(R.drawable.h6);
                MLB.add(R.drawable.h7);
                MLB.add(R.drawable.h8);
                MLB.add(R.drawable.h9);
                MLB.add(R.drawable.h10);
                MLB.add(R.drawable.hj);
                MLB.add(R.drawable.hq);
                MLB.add(R.drawable.hk);

                MLB.add(R.drawable.d1);
                MLB.add(R.drawable.d2);
                MLB.add(R.drawable.d3);
                MLB.add(R.drawable.d4);
                MLB.add(R.drawable.d5);
                MLB.add(R.drawable.d6);
                MLB.add(R.drawable.d7);
                MLB.add(R.drawable.d8);
                MLB.add(R.drawable.d9);
                MLB.add(R.drawable.d10);
                MLB.add(R.drawable.dj);
                MLB.add(R.drawable.dq);
                MLB.add(R.drawable.dk);

                Random random = new Random();
                int temp1,temp2,temp3;
                temp1 = random.nextInt(MLB.size());
                do{
                    temp2 = random.nextInt(MLB.size());
                }while(temp1 == temp2);

                do{
                    temp3 = random.nextInt(MLB.size());
                }while(temp1 == temp3 || temp2 == temp3);
                imgLB1.setImageResource(MLB.get(temp1));
                imgLB2.setImageResource(MLB.get(temp2));
                imgLB3.setImageResource(MLB.get(temp3));
                int diem = TD(temp1) + TD(temp2) + TD(temp3);
                if(TD1(temp1) == TD1(temp2) && TD1(temp1) == TD1(temp3))
                {
                    txtScore.setText("SÁP");
                }
                else if(check(TD1(temp1),TD1(temp2),TD1(temp3)) == true)
                {
                    txtScore.setText("LIÊNG");
                }
                else if(TD1(temp1) > 10 && TD1(temp2) > 10 && TD1(temp3) > 10)
                {
                    txtScore.setText("3 TIÊN");
                }
                else
                    {
                    diem = diem%10;
                    txtScore.setText(String.valueOf(diem));
                    }

            }
        });
    }
    private int TD(int x){
        int temp = x + 1;
        temp = temp%13;
        if(temp > 10){
            temp = 10;
        }
        return temp;
    }
    private int TD1(int x){
        int temp = x + 1;
        temp = temp%13;
        if(temp == 0) temp = 13;
        return temp;
    }
    private boolean check(int x, int y, int z){
        if((x - y == 1 && x - z == 2) || (x - z == 1 && x - y == 2))
        {
            return true;
        }
        if((x - y == 1 && z - x == 1) || x - z == 1 && y - x == 1)
        {
            return true;
        }
        if((y-x == 1 && z-x == 2) || (z-x == 1 && y-x == 2))
        {
            return true;
        }
        return false;
    }
}