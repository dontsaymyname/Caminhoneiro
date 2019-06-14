package com.example.quizcaminhoneiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class RadioButtonActivity extends AppCompatActivity {


    private Quiz quiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);


        Bundle bundle = getIntent().getExtras();

        quiz = (Quiz) bundle.getSerializable("QUIZ");

        Button button = findViewById(R.id.buttoncaminhao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaCores();
            }
        });

    } private void irParaCores(){

        Intent intent = new Intent(this, Cores.class);

        Bundle bundle = new Bundle();

        RadioButton rbCarreto = findViewById(R.id.rb_carreto);
        RadioButton rbCegonha = findViewById(R.id.rb_cegonha);
        RadioButton rbLixo = findViewById(R.id.rb_lixo);
        RadioButton rbFrigorifico = findViewById(R.id.rb_frigorifico);

        if (rbCarreto.isChecked()){
            quiz.setCaminhao("Carreto");
        }else if (rbCegonha.isChecked()){
            quiz.setCaminhao("Cegonha");
        }else if (rbFrigorifico.isChecked()){
            quiz.setCaminhao("Frigorífico");
        }else if (rbLixo.isChecked()){
            quiz.setCaminhao("Lixo");
        }

        bundle.putSerializable("QUIZ", quiz);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
