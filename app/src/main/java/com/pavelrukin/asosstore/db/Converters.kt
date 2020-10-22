package com.pavelrukin.asosstore.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pavelrukin.asosstore.model.detail_product.*



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
    fun fromInfoToJson(stat: Info?): String {
        return Gson().toJson(stat)
    }
    @TypeConverter
    fun fromJsonToInfo(jsonInfo: String): Info? {
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

}

