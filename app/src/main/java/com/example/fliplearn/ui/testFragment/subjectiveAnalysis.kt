package com.example.fliplearn.ui.testFragment

import android.app.AlertDialog
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.Window
import com.example.fliplearn.R
import kotlinx.android.synthetic.main.activity_subjective_analysis.*
import kotlinx.android.synthetic.main.subjective_analysis.view.*

class subjectiveAnalysis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjective_analysis)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Calculating Score..")



        submitButton.setOnClickListener {
            progressDialog.show()
            Handler().postDelayed(object : Runnable{
                override fun run() {
                    runOnUiThread {
                        progressDialog.dismiss()
                        val dialog = AlertDialog.Builder(this@subjectiveAnalysis)
                        val dialogView = LayoutInflater.from(this@subjectiveAnalysis).inflate(R.layout.subjective_analysis,null)
                        dialog.setView(dialogView)
                        dialog.setCancelable(false)
                        val alertDialog = dialog.create()
                        dialogView.exit.setOnClickListener {
                            finish()
                        }
                        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                        alertDialog.show()
                    }
                }
            },2000)
        }
    }
}