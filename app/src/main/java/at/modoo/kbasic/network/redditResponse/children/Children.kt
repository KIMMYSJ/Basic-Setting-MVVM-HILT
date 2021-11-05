package at.modoo.kbasic.network.redditResponse.children

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("kind")
    @Expose
    var kind:String,
    @SerializedName("data")
    @Expose
    var data:Data,
)