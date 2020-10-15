package com.example.fliplearn.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fliplearn.R
import com.example.fliplearn.ui.auth.LoginActivity
import com.example.fliplearn.utils.FunctionUtils
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {

    var aboutus: MaterialCardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v =  inflater.inflate(R.layout.fragment_profile, container, false)
        v.cardSettings.setOnClickListener(View.OnClickListener { upload: View? ->
                FunctionUtils().toaster(
                    "Coming Soon!",
                    context!!
                )
            })
        v.cardSavedPosts.setOnClickListener(View.OnClickListener { doc: View? ->
                FunctionUtils().toaster(
                    "Coming Soon!",
                    context!!
                )
            })
        v.ivLogout.setOnClickListener(View.OnClickListener { logout: View? ->
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(context, LoginActivity::class.java))
                activity!!.finish()
            })
        aboutus = v.findViewById(R.id.cardAbout)
        aboutus!!.setOnClickListener({ v1 ->
            //Start the about us Activity
        })

        return v
    }


}