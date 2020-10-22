package com.pavelrukin.asosstore.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pavelrukin.asosstore.model.detail_product.*
import com.pavelrukin.asosstore.model.product.Price


class Converters {

    @TypeConverter
    fun fromMediaToJson(stat: Media?): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun fromJsonToMedia(jsonMedia: String): Media? {
        val type = object : TypeToken<Media?>() {}.type
        return Gson().fromJson<Media>(jsonMedia, type)
    }
    
    @TypeConverter
        fun fromImageToJson(stat: List<Image>?): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun fromJsonToImage(jsonImages: String): List<Image>? {
        val type = object : TypeToken<List<Image?>>() {}.type
        return Gson().fromJson<List<Image>>(jsonImages, type)
    }
    
    @TypeConverter
    fun fromInfoToJson(stat: Info?): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun fromJsonToInfo(jsonInfo: String): Info?? {
        val type = object : TypeToken<Info?>() {}.type
        return Gson().fromJson<Info?>(jsonInfo, type)
    }

    @TypeConverter
    fun fromPriceDetailToJson(stat: PriceDetail?): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun fromJsonToPriceDetail(jsonPrice: String): PriceDetail? {
        val type = object : TypeToken<PriceDetail?>() {}.type
        return Gson().fromJson<PriceDetail?>(jsonPrice, type)
    }


    @TypeConverter
    fun fromPriceToJson(stat: Price?): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun fromJsonToPrice(jsonPrice: String): Price? {
        val type = object : TypeToken<Price?>() {}.type
        return Gson().fromJson<Price?>(jsonPrice, type)
    }


   /* @TypeConverter
    fun fromAlternateNameToJson(stat: AlternateName?): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun fromJsonToAlternateName(jsonAlternateName: String): AlternateName {
        val type = object : TypeToken<AlternateName>() {}.type
        return Gson().fromJson<AlternateName>(jsonAlternateName, type)
    }*/




}

