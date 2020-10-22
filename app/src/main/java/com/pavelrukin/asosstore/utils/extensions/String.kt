package com.pavelrukin.asosstore.utils.extensions

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator


fun String.replaceHtmlTag() = replace("\\<.*?\\>".toRegex(), "\n").replace("\n","")
var myRe = "/\\<.*?\\\n>/g"

fun String.replaceHtmlTag2() = replace(myRe. toRegex(),"")
fun String.imgHelper() = split(',')[0].replace("[","")




