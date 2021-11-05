package at.modoo.kbasic.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class Blog(
        var author:String,
        var title:String,
        var thumbnail:String,
        var id:String
    ){
    companion object {
        @BindingAdapter("android:loadImage")
        @JvmStatic
        fun loadImage(imageView: ImageView,imageUrl:String){
            Glide.with(imageView).load(imageUrl).into(imageView)
        }
    }
}
