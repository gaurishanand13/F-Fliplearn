package com.example.fliplearn.ui.doubts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.model.doubtsModel
import com.example.fliplearn.ui.main.ViewHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.doubts_item.view.*

class DoubtsAdapter(val list: ArrayList<doubtsModel>, val context: Context?) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.doubts_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.doubtCoinsAdded.text = "+${list.get(position).coins}"
        holder.itemView.doubtProfileImage.setImageResource(list.get(position).profile)
        holder.itemView.doubtName.text = list.get(position).name
        holder.itemView.doubtSubject.text = list.get(position).subject
        holder.itemView.tvAnswer.setOnClickListener {
            Toast.makeText(context, "Answer sent successfully!!\nYou earned 10 Flipcoins", Toast.LENGTH_SHORT).show()
        }


        if (list.get(position).text != null) {
            holder.itemView.doubtTextView.text = list.get(position).text
        } else {
            holder.itemView.doubtTextView.visibility = View.GONE
        }

        if (list.get(position).drawable != null) {
            holder.itemView.doubtImageView.setImageResource(list.get(position).drawable!!)
        } else if (list.get(position).uri != null) {
            Picasso.get().load(list.get(position).uri).into(holder.itemView.doubtImageView)
        } else {
            holder.itemView.doubtImageView.visibility = View.GONE
        }
    }

    fun addList(x: doubtsModel) {
        val newList = ArrayList<doubtsModel>()
        newList.addAll(list)
        list.clear();
        list.add(x)
        list.addAll(newList)
        notifyDataSetChanged()
    }
}