package com.pavelrukin.asosstore.utils.extensions



fun String.replaceHtmlTag() = replace("\\<.*?\\>".toRegex(), "\n").replace("\n","")
var myRe = "/\\<.*?\\\n>/g"

fun String.replaceHtmlTag2() = replace(myRe. toRegex(),"")
