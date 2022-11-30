package com.example.semelhanteartista

import android.annotation.SuppressLint
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
    private lateinit var recyclerView_artistas: RecyclerView;
    private var listaBandas: MutableList<Indicacao> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendacoes)
        recyclerView_artistas = findViewById<RecyclerView>(R.id.recyclerView_artistas)
        recyclerView_artistas.layoutManager = LinearLayoutManager(this)
        recyclerView_artistas.setHasFixedSize(true)
        val adapterBanda = AdapterBanda(this,listaBandas)
        recyclerView_artistas.adapter = adapterBanda
    }

    override fun onResume() {
        super.onResume()
        val dados = intent.getStringExtra("banda")
        dados?.let {
            getSuggestions(dados)
        }
    }

    private fun getSuggestions(banda: String) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://tastedive.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val artist: Artist = retrofit.create(Artist::class.java)

            val call = artist.getPosts(banda)
            call.enqueue(object : Callback<ResponseApiSimilar> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<ResponseApiSimilar>, response: Response<ResponseApiSimilar>) {
                    if (!response.isSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "Error " + response.code() + ": " + response.message(),
                            Toast.LENGTH_SHORT
                        ).show()
                        return
                    }
                    val bodyResponse = response.body() ?: return
                    val postsArtist = bodyResponse.similar?.results ?: return

                    listaBandas.clear()
                    for (postArtist in postsArtist) {
                        val indicacao = Indicacao(postArtist?.getName().toString())
                        listaBandas.add(indicacao)
                    }
                    recyclerView_artistas.adapter?.notifyDataSetChanged();
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