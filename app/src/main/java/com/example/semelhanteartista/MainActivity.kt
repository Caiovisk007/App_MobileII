package com.example.semelhanteartista

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), androidx.appcompat.widget.SearchView.OnQueryTextListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configSearchView()
    }

    private fun configSearchView() {
        val search = findViewById<androidx.appcompat.widget.SearchView>(R.id.searchmain)
        search.setOnQueryTextListener(this@MainActivity)
        search.isSubmitButtonEnabled = true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            val intenttwisted = Intent(this, Recomendacoes::class.java)
            intenttwisted.putExtra("banda", it)
            startActivity(intenttwisted)
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return false
    }
}