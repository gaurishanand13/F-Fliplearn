package com.example.fliplearn.ui.BotChat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fliplearn.R
import com.example.fliplearn.model.Constants
import kotlinx.android.synthetic.main.activity_chat_bot.*

class ChatBotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)

        val list = ArrayList<String>()
        list.add(Constants.botAnswers.get(0))
        chatBotRecylerView.layoutManager = LinearLayoutManager(this)
        val adapter = chatAdapter(list)
        chatBotRecylerView.adapter = adapter
    }
}