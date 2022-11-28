package com.example.semelhanteartista

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Similar {
    @SerializedName("Results")
    @Expose
    internal var results: List<PostArtist?>? = null

    fun getResults(): List<PostArtist?>? {
        return results
    }

    fun setResults(results: List<PostArtist?>?) {
        this.results = results
    }
}