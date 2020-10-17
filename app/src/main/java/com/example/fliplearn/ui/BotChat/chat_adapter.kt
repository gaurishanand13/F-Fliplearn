package com.example.fliplearn.ui.BotChat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import com.example.fliplearn.model.doubtsModel
import com.example.fliplearn.ui.main.viewHolder
import kotlinx.android.synthetic.main.chat_item.view.*
import kotlinx.android.synthetic.main.doubts_item.view.*


class chatAdapter(val list: ArrayList<String>): RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.chat_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        if(position%2==0){
            //It means message is from the bot, therefore hide personTextView
            holder.itemView.personTextView.visibility = View.GONE
            holder.itemView.chatBotTextView.text = list.get(position)
        }
        else{
            //It means message is from the user
            holder.itemView.chatBotTextView.visibility = View.GONE
            holder.itemView.personTextView.text = list.get(position)
        }
    }

    fun updateListAdd(s : String){
        list.add(s)
        list.add(Constants.botAnswers.get(list.size))
        notifyDataSetChanged()
    }
}