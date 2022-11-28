package com.example.semelhanteartista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.semelhanteartista.Adapter.AdapterBanda
import com.example.semelhanteartista.model.Indicacao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Recomendacoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendacoes)

        val recyclerView_artistas = findViewById<RecyclerView>(R.id.recyclerView_artistas)
        recyclerView_artistas.layoutManager = LinearLayoutManager(this)
        recyclerView_artistas.setHasFixedSize(true)

        val listaBandas: MutableList<Indicacao> = mutableListOf()
        val adapterBanda = AdapterBanda(this,listaBandas)
        recyclerView_artistas.adapter = adapterBanda

        val indicacao1 = Indicacao(
            " "
        )
        listaBandas.add(indicacao1)

        val indicacao2 = Indicacao(
            " "
        )
        listaBandas.add(indicacao2)

        val indicacao3 = Indicacao(
            " "
        )
        listaBandas.add(indicacao3)

        val indicacao4 = Indicacao(
            " "
        )
        listaBandas.add(indicacao4)

        val indicacao5 = Indicacao(
            " "
        )
        listaBandas.add(indicacao5)
    }

    override fun onResume() {
        super.onResume()
        getSuggestions()
    }

    private fun getSuggestions() {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://tastedive.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val artist: Artist = retrofit.create(Artist::class.java)
            val call = artist.getPosts("nirvana")

            Log.e("API", "URL: ${call.request().url.toString()}")
            call.enqueue(object : Callback<ResponseApiSimilar> {
                override fun onResponse(call: Call<ResponseApiSimilar>, response: Response<ResponseApiSimilar>) {
                    if (!response.isSuccessful) {
                        Log.e("API", "API: ${response.raw()}")
                        Toast.makeText(
                            applicationContext,
                            "Error " + response.code() + ": " + response.message(),
                            Toast.LENGTH_SHORT
                        ).show()
                        return
                    }
                    val response = response.body()
                    Log.e("API", "RESULTS: ${response?.similar?.results}")
                    val postsArtist = response?.similar?.results ?: return
                    for (postArtist in postsArtist) {
                        Log.e("API", "NOME: ${postArtist?.getName().toString()}")

                    }
                }

                override fun onFailure(call: Call<ResponseApiSimilar>, t: Throwable) {
                    Log.e("API", "ERROR API: ${t.message}")
                }
            })
        } catch (e: Exception) {
            Log.e("API", "ERROR: ${e.message}")
        }
    }
}