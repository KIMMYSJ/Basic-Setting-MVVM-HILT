package at.modoo.kbasic.network.redditResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Feed (
    @SerializedName("kind")
    @Expose
    var kind:String,
    @SerializedName("data")
    @Expose
    var data:Data,



)