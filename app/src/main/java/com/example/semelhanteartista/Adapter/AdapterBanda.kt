package com.example.semelhanteartista.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.semelhanteartista.R
import com.example.semelhanteartista.model.Indicacao

class AdapterBanda(private val context: Context, private val indicacoes: MutableList<Indicacao>): RecyclerView.Adapter<AdapterBanda.BandaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandaViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.artist_item,parent,false)
        val holder = BandaViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: BandaViewHolder, position: Int) {
        holder.nome.text = indicacoes[position].nomeBanda
    }

    override fun getItemCount(): Int = indicacoes.size

    inner class BandaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.nome_artista)
    }
}