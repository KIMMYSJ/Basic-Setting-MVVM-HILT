package at.modoo.kbasic.utility

import androidx.recyclerview.widget.DiffUtil
import at.modoo.kbasic.model.Blog

class CustomDiffUtil(
    private val oldList:List<Blog>,
    private val newList:List<Blog>
):DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size;
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id->{
                false
            }
            oldList[oldItemPosition].thumbnail != newList[newItemPosition].thumbnail->{
                false
            }
            oldList[oldItemPosition].author != newList[newItemPosition].author->{
                false
            }
            oldList[oldItemPosition].title != newList[newItemPosition].title->{
                false
            }
            else ->true
        }
    }
}