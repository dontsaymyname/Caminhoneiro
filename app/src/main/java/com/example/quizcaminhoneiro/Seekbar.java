package com.example.quizcaminhoneiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Seekbar extends AppCompatActivity {

    TextView percentual;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        percentual = findViewById(R.id.percentual_textView);

        seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentual.setText(progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button buttonSeek = findViewById(R.id.button_seek);
        buttonSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                irParaCaminhao();

            }
        });
    }

    public void irParaCaminhao (){

        Intent intent = new Intent(this, RadioButtonActivity.class);

        Bundle bundle = new Bundle();

        Quiz quiz = new Quiz();

        quiz.setPercentual(seekbar.getProgress());

        bundle.putSerializable("QUIZ", quiz);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
