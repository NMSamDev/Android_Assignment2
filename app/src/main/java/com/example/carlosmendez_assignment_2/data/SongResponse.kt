package com.example.data.carlosmendez_assignment_2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.URL

@Parcelize
data class SongResponse(
    val results: List<Song>
) : Parcelable

@Parcelize
data class Song(
    val artistName: String,
    val collectionName: String,
    val artworkUrl60: String,
    val trackPrice: String,
    val previewUrl: String
) : Parcelable

