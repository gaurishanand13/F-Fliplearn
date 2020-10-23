package com.example.fliplearn.ui.profile.notes

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.transition.Transition
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.example.fliplearn.R
import kotlinx.android.synthetic.main.activity_note_taking.*


class NoteTakingActivity : AppCompatActivity() {
    private var paintView: PaintView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_taking)
        val actionBar: android.app.ActionBar? = actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        paintView = findViewById(R.id.paint_view)

        intent?.extras?.get("image")?.let {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
            previous.visibility = View.VISIBLE
            paintView?.visibility = View.GONE
            Glide.with(this).load(it).into(previous)
        }

        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        paintView!!.init(metrics)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.paint_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.pen -> {
                paintView!!.pen()
                Toast.makeText(this, "Pen Active!", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.eraser -> {
                paintView!!.eraser()
                Toast.makeText(this, "Eraser Active!", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.clear -> {
                paintView!!.clear()
                Toast.makeText(this, "Canvas Empty!", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
