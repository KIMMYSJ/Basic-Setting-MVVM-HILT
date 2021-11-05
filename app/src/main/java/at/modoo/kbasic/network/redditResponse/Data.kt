package at.modoo.kbasic.network.redditResponse

import at.modoo.kbasic.network.redditResponse.children.Children
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("children")
    @Expose
    var children:List<Children>
)
