package com.example.fliplearn.model

import android.graphics.drawable.Drawable
import android.net.Uri
import com.example.fliplearn.R

data class doubtsModel(
    val coins : String,
    val name : String,
    val subject : String,
    val text : String?,
    val drawable : Int?,
    val profile : Int,
    val uri  : Uri?
)

