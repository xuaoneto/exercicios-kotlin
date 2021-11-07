package com.example.pratica3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class TelaCriarNovaCor : AppCompatActivity() {
    private lateinit var fieldtext: TextView
    private lateinit var containerSliders: View
    private lateinit var background: View
    private lateinit var inputslider1: SeekBar
    private lateinit var inputslider2: SeekBar
    private lateinit var inputslider3: SeekBar
    private lateinit var rgbText: String
    private lateinit var barrasuperior: View
    private lateinit var buttoncancel: Button
    private lateinit var buttonsave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_criar_nova_cor)
        this.buttoncancel = findViewById(R.id.buttoncancel);
        this.buttonsave = findViewById(R.id.buttonsave);

        this.inputslider1 = findViewById(R.id.seekBar);
        this.inputslider2 = findViewById(R.id.seekBar2);
        this.inputslider3 = findViewById(R.id.seekBar3);
        this.barrasuperior = findViewById(R.id.action_bar);
        barrasuperior.setBackgroundColor(android.graphics.Color.rgb(160,160,160));

        this.inputslider1.setOnSeekBarChangeListener(OnChange());
        this.inputslider2.setOnSeekBarChangeListener(OnChange());
        this.inputslider3.setOnSeekBarChangeListener(OnChange());

        this.containerSliders = findViewById(R.id.inputscontainer)
        this.fieldtext = findViewById(R.id.colorrgb);
        this.background = findViewById(R.id.showcolor);

        buttoncancel.setOnClickListener{
            goToFirstScreen()
        }
        buttonsave.setOnClickListener{
            sendValuesFromMain(getValuesOfSliders())
        }

    }
    private fun sendValuesFromMain(values: MutableList<Int>){
        val primaryScreen = Intent(this,MainActivity::class.java);
        val params = Bundle();
        var colorValues:ArrayList<Int> = arrayListOf();
        colorValues.add(values[0]);
        colorValues.add(values[1]);
        colorValues.add(values[2]);
        params.putIntegerArrayList("Color", colorValues)
        primaryScreen.putExtras(params);
        startActivity(primaryScreen);
    }


    private fun goToFirstScreen(){
        val primaryScreen = Intent(this,MainActivity::class.java);
        startActivity(primaryScreen);
    }

    fun getValuesOfSliders(): MutableList<Int>{
        var lista:MutableList<Int> = mutableListOf();

        lista.add(this.inputslider1.progress);
        lista.add(this.inputslider2.progress);
        lista.add(this.inputslider3.progress);

        return lista
    }
    inner class OnChange : SeekBar.OnSeekBarChangeListener {
        private lateinit var valuesOfSliders: MutableList<Int>

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this.valuesOfSliders = getValuesOfSliders();
            this@TelaCriarNovaCor.setBackgroundOf(valuesOfSliders);
            this@TelaCriarNovaCor.setValueText(valuesOfSliders);

        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {};
        override fun onStopTrackingTouch(seekBar: SeekBar?) {};
    }
    fun setBackgroundOf(array: MutableList<Int>){
        this.background.setBackgroundColor(android.graphics.Color.rgb(array[0],array[1],array[2]));
    }
    fun setValueText(array: MutableList<Int>){
        this.rgbText = "rgb(" + array[0].toString() + "," + array[1].toString() + "," + array[2].toString() + ")"
        this.fieldtext.text = this.rgbText;
        if (rgbText == "rgb(0,0,0)"){
            this.fieldtext.setTextColor(android.graphics.Color.rgb(255,255,255))
        }else{
            this.fieldtext.setTextColor(android.graphics.Color.rgb(0,0,0))
        }
    }
}
















