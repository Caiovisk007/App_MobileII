package com.example.semelhanteartista

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class PostArtist {
    @SerializedName("Name")
    @Expose
    private var name: String? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }
}