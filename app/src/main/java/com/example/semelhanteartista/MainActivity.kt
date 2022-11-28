package com.example.semelhanteartista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var menu: Spinner
    lateinit var ledzeppelin_click: TextView
    lateinit var pinkfloyd_click: TextView
    lateinit var ironmaiden_click: TextView
    lateinit var beatles_click: TextView
    lateinit var twisted_click: TextView
    lateinit var redhot_click: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu = findViewById(R.id.spinner_main)
        var opcoes = arrayOf(" 1 "," 2 "," 3 "," 4 "," 5 ")
        menu.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,opcoes)

        ledzeppelin_click = findViewById(R.id.led)
        ledzeppelin_click.setOnClickListener{
            IrParaRecomendacoes()
        }

        pinkfloyd_click = findViewById(R.id.pink_floyd)
        pinkfloyd_click.setOnClickListener{
            IrParaRecomendacoes()
        }

        ironmaiden_click = findViewById(R.id.iron_maiden)
        ironmaiden_click.setOnClickListener{
            IrParaRecomendacoes()
        }

        beatles_click = findViewById(R.id.beatles)
        beatles_click.setOnClickListener{
            IrParaRecomendacoes()
        }

        twisted_click = findViewById(R.id.twisted_sister)
        twisted_click.setOnClickListener{
            IrParaRecomendacoes()
        }

        redhot_click = findViewById(R.id.red_hot)
        redhot_click.setOnClickListener{
            IrParaRecomendacoes()
        }
    }

    private fun IrParaRecomendacoes(){
        val telaRecomendacoes = Intent(this,Recomendacoes::class.java)
        startActivity(telaRecomendacoes)
    }
}