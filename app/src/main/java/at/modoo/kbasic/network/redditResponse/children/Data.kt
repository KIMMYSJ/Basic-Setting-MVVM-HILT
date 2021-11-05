package at.modoo.kbasic.network.redditResponse.children

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("author")
    @Expose
    var author:String,
    @SerializedName("title")
    @Expose
    var title:String,
    @SerializedName("thumbnail")
    @Expose
    var thumbnail:String,
    @SerializedName("id")
    @Expose
    var id:String
)
