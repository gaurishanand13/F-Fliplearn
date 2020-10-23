package com.example.fliplearn.ui.profile.notes

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fliplearn.R

class NotesAdapter(val context: Context, val notes: ArrayList<NotesData>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val title = itemView.findViewById<TextView>(R.id.english_title)
        val updated = itemView.findViewById<TextView>(R.id.updated)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context).inflate(R.layout.notes_item, parent, false)
        return ViewHolder(inflater)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(notes[position].imgUrl).into(holder.image)
        holder.title.text = notes[position].title.toString()
        holder.updated.text = "Updated: ${notes[0].updated.toString()}"
        holder.itemView.setOnClickListener {
            openNoteTaking(notes[position].imgUrl)
            Toast.makeText(
                context,
                notes[position].imgUrl,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openNoteTaking(imgUrl: String) {
        val intent = Intent(context, NoteTakingActivity::class.java)
        intent.putExtra("image", imgUrl)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}