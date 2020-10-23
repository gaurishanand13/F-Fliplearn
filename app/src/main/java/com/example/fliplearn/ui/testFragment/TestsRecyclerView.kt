package com.example.fliplearn.ui.testFragment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fliplearn.R
import com.example.fliplearn.ui.main.ViewHolder
import com.example.fliplearn.ui.onlineTestActivity.onlineTestActivity
import kotlinx.android.synthetic.main.test_item.view.*
import kotlin.collections.ArrayList

class TestsRecyclerView(val list: ArrayList<testModel>, val context: Context): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutInflater.inflate(R.layout.test_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.testTextView.text = list.get(position).testName
        holder.itemView.testImageView.setImageResource(list.get(position).res)
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,subjectiveAnalysis::class.java))
        }
    }
}