package com.example.versionchoice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch swStart;
    TextView tvTitle;
    RadioGroup rGroup;
    //RadioButton rdNuga, rdOreo, rdPie;
    RadioButton rdoVer[]=new RadioButton[3];
    int verIDs[]={R.id.rdNuga, R.id.rdOreo, R.id.rdPie};
    int imgIDs[]={R.drawable.android, R.drawable.jellybean, R.drawable.lollipop};
    ImageView imImg;
    Button btnReStart, btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swStart=findViewById(R.id.swStart);
        tvTitle=findViewById(R.id.tvTitle);
        rGroup=findViewById(R.id.rdGroup);
//        rdNuga=findViewById(R.id.rdNuga);
//        rdOreo=findViewById(R.id.rdOreo);
//        rdPie=findViewById(R.id.rdPie);
        imImg=findViewById(R.id.imImg);
        btnFinish=findViewById(R.id.btnFinish);
        btnReStart=findViewById(R.id.btnReStart);

        //라디오 버튼 클릭 시 이미지 변경_라디오버튼 그룸을 이용.
        for(int i=0; i<rdoVer.length; i++){
            rdoVer[i] = findViewById(verIDs[i]);
        }

        for(int i=0; i<imgIDs.length; i++){
            final int index;
            index=i;
            rdoVer[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imImg.setImageResource(imgIDs[index]);
                }
            });
        }

        //시작함을 클릭할 경우 가려져있던 나머지 보이기.
        swStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    tvTitle.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    imImg.setVisibility(View.VISIBLE);
                    btnFinish.setVisibility(View.VISIBLE);
                    btnReStart.setVisibility(View.VISIBLE);
                } else{
                    tvTitle.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    imImg.setVisibility(View.INVISIBLE);
                    btnFinish.setVisibility(View.INVISIBLE);
                    btnReStart.setVisibility(View.INVISIBLE);
                }
            }
        });

        //라디오 버튼 클릭 시 이미지 변경_라디오버튼 하나를 이용.
        /*rdPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imImg.setImageResource(R.drawable.android);
            }
        });*/

        //종료버튼 클릭 시 프로그램 종료.
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //처음부터 버튼 클릭 시 스위치버튼부터 초기화
        btnReStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swStart.setChecked(false);
                rGroup.clearCheck();
                imImg.setImageResource(0);
            }
        });

    }
}