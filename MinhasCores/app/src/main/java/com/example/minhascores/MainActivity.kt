package com.example.minhascores

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lista: ListView;
    private lateinit var addcor: FloatingActionButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = findViewById(R.id.lista)
        this.addcor = findViewById(R.id.addcor);


        ListaCores()

        addcor.setOnClickListener{
            goToSecondScreen()
        }
        BancoController(getBaseContext());
    }
    private fun goToSecondScreen(){
        val secondScreen = Intent(this,CriarCor::class.java);
        startActivity(secondScreen);
    }

    fun ListaCores() {
        val crud = BancoController(baseContext);
        Consulta()
    }

}