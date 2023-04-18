package com.example.training;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean buttonTap = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンビューを3つ取得
        Button buttonRed = findViewById(R.id.button_1);
        Button buttonBlue = findViewById(R.id.button_2);
        Button buttonYellow = findViewById(R.id.button_3);

        //ボタンを押されたときの動作を持つインスタンスを生成
        ButtonClickListener listener = new ButtonClickListener();

        //ボタンにButtonClickListenerインスタンスをセット
        buttonRed.setOnClickListener(listener);
        buttonBlue.setOnClickListener(listener);
        buttonYellow.setOnClickListener(listener);

    }
    //ボタンを押されたときの動作を定義するクラスを作成
    private class ButtonClickListener implements View.OnClickListener{

        //ボタンを押されたときの動作を定義
        @SuppressLint("StringFormatInvalid")
        @Override
        public void onClick(View view){

            //結果を出力するテキストビューを取得
            TextView color =findViewById(R.id.button_text);
            //押されたボタンのidを取得
            int id = view.getId();

            //押されたボタンのidによって条件分岐
            switch (id) {

                //赤色ボタンの時
                case R.id.button_1:
                    //テキスト『赤色』を表示
                    Intent intent = new Intent(getApplication(), SubActivity.class);
                    startActivity(intent);
                    break;
                //青色ボタンの時
                case R.id.button_2:
                    //テキスト『青色』を表示
                    color.setText(getResources().getString(R.string.b2, R.string.selecting));
                    break;
                //黄色ボタンの時
                case R.id.button_3:
                    //テキスト『黄色』を表示
                    color.setText(getResources().getString(R.string.b3, R.string.selecting));
                    break;
            }
        }
    }
}