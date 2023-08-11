package com.yaman.myapp.rx_java_tutorials;
import com.google.gson.annotations.SerializedName


data class ResponseApi(
    @SerializedName("dataseries")
    var dataseries: List<Datasery>,
    @SerializedName("product")
    var product: String
)

data class Datasery(
    @SerializedName("cloudcover")
    var cloudcover: Int,
    @SerializedName("lifted_index")
    var liftedIndex: Int,
    @SerializedName("prec_type")
    var precType: String,
    @SerializedName("rh2m")
    var rh2m: Int,
    @SerializedName("seeing")
    var seeing: Int,
    @SerializedName("temp2m")
    var temp2m: Int,
    @SerializedName("timepoint")
    var timepoint: Int,
    @SerializedName("transparency")
    var transparency: Int,
    @SerializedName("wind10m")
    var wind10m: Wind10m
)


data class Wind10m(
    @SerializedName("direction")
    var direction: String,
    @SerializedName("speed")
    var speed: Int
)