package com.example.semelhanteartista

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ResponseApiSimilar {
    @SerializedName("Similar")
    @Expose
    internal var similar: Similar? = null

    fun getSimilar(): Similar? {
        return similar
    }

    fun setSimilar(similar: Similar?) {
        this.similar = similar
    }
}