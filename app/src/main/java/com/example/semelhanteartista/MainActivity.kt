package com.example.semelhanteartista

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
            val intentled = Intent(this, Recomendacoes::class.java)
            intentled.putExtra("led","led zeppelin")
            startActivity(intentled)
        }

        pinkfloyd_click = findViewById(R.id.pink_floyd)
        pinkfloyd_click.setOnClickListener{
            val intentpink = Intent(this, Recomendacoes::class.java)
            intentpink.putExtra("pink","pink floyd")
            startActivity(intentpink)
        }

        ironmaiden_click = findViewById(R.id.iron_maiden)
        ironmaiden_click.setOnClickListener{
            val intentiron = Intent(this, Recomendacoes::class.java)
            intentiron.putExtra("iron","iron maiden")
            startActivity(intentiron)
        }

        beatles_click = findViewById(R.id.beatles)
        beatles_click.setOnClickListener{
            val intentbeatles = Intent(this, Recomendacoes::class.java)
            intentbeatles.putExtra("beatles","the beatles")
            startActivity(intentbeatles)
        }

        twisted_click = findViewById(R.id.twisted_sister)
        twisted_click.setOnClickListener{
            val intenttwisted = Intent(this, Recomendacoes::class.java)
            intenttwisted.putExtra("twisted","twisted sister")
            startActivity(intenttwisted)
        }

        redhot_click = findViewById(R.id.red_hot)
        redhot_click.setOnClickListener{
            val intentredhot = Intent(this, Recomendacoes::class.java)
            intentredhot.putExtra("redhot","red hot chili peppers")
            startActivity(intentredhot)
        }
    }
}