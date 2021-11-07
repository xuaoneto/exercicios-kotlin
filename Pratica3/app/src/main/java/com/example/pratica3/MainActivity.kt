package com.example.pratica3

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var setNewColor: Button
    private lateinit var actualcolor: View
    private lateinit var showcolornumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.showcolornumber = findViewById(R.id.showcolornumber);

        this.actualcolor = findViewById(R.id.actualcolor);

        this.setNewColor = findViewById(R.id.setNewColor);

        setNewColor.setOnClickListener{
            goToSecondScreen()
        }

        setSavedColor()
    }

    private fun goToSecondScreen(){
        val secondScreen = Intent(this,TelaCriarNovaCor::class.java);
        startActivity(secondScreen);
    }
    private fun setSavedColor(){
        val colorValues =  intent.extras?.getIntegerArrayList("Color")
        if (colorValues != null){
            this.actualcolor.setBackgroundColor(android.graphics.Color.rgb(colorValues[0],colorValues[1],colorValues[2]));
            this.showcolornumber.text = "rgb(" + colorValues[0].toString() + "," + colorValues[1].toString() + "," + colorValues[2].toString() + ")"
        }else{
            this.actualcolor.setBackgroundColor(android.graphics.Color.rgb(255,255,255));
            this.showcolornumber.text = "rgb(255,255,255)";
        }
        if(this.showcolornumber.text == "rgb(0,0,0)"){
            this.showcolornumber.setTextColor(android.graphics.Color.rgb(255,255,255))
        }
    }

}



















