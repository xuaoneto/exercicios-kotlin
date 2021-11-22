package com.example.minhascores;

import static android.graphics.Color.rgb;
import static java.lang.Integer.toHexString;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class InsereDado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button)findViewById(R.id.buttonsave);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText name = (EditText)findViewById(R.id.inputname);
                SeekBar inputslider1 = findViewById(R.id.seekBar);
                SeekBar inputslider2 = findViewById(R.id.seekBar2);
                SeekBar inputslider3 = findViewById(R.id.seekBar3);

                int r = inputslider1.getProgress();
                int g = inputslider2.getProgress();
                int b = inputslider3.getProgress();

                String rgbText = toHexString(rgb(r,g,b)).substring(2,8).toUpperCase();
                String codigoString = "#"+rgbText ;

                String nameString = name.getText().toString();


                String resultado;

                resultado = crud.insereDado(nameString, codigoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }


}