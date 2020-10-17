package com.example.fliplearn.ui.doubts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import kotlinx.android.synthetic.main.fragment_doubts.*
import kotlinx.android.synthetic.main.fragment_doubts.view.*

class doubtsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("heyy!","In doubts Fragment")
        val view =  inflater.inflate(R.layout.fragment_doubts, container, false)
        view.doubtsRecyclerView.layoutManager = LinearLayoutManager(context)
        view.doubtsRecyclerView.adapter = doubtsAdapter(Constants.getDoubts(),context)
        return view
    }
}