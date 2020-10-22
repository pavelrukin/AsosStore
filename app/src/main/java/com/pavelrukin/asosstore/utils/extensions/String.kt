package com.pavelrukin.asosstore.utils.extensions


fun String.replaceHtmlTag() = replace("\\<.*?\\>".toRegex(), "\n").replace("\n", "")

fun String.imgHelper() = split(',')[0].replace("[", "")




