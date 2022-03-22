package com.android.starwarscatapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.android.starwarscatapp.R
import com.android.starwarscatapp.model.Result
import com.squareup.picasso.Picasso

class CharactersAdapter(
    private val songs: MutableList<Result> = mutableListOf(),
    private val onSongClicked: (Result) -> Unit
): RecyclerView.Adapter<PeopleViewHolder>() {

    fun updateSongs(newSongs: List<Result>) {
        songs.clear()
        songs.addAll(newSongs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val songView = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item, parent, false)
        return PeopleViewHolder(songView, onSongClicked)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val song = songs[position]
        holder.bind(song)
    }

    override fun getItemCount(): Int = songs.size

}

class PeopleViewHolder(
    itemView: View,
    private val onSongClicked: (Result) -> Unit
): RecyclerView.ViewHolder(itemView){
    private val songName : TextView = itemView.findViewById(R.id.songName)
    private val artistName : TextView = itemView.findViewById(R.id.artistName)
    private val price : TextView = itemView.findViewById(R.id.price)
    private val albumCover : ImageView = itemView.findViewById(R.id.albumCover)

    fun bind(song: Result) {
        songName.text = song.trackName
        artistName.text = song.artistName
        price.text = song.trackPrice.toString()

        itemView.setOnClickListener {
            onSongClicked.invoke(song)
        }

        Picasso.get()
            .load(song.artworkUrl100)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .fit()
            .into(albumCover)
    }
}