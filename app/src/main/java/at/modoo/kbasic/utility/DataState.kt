package at.modoo.kbasic.utility

import at.modoo.kbasic.model.Blog
import at.modoo.kbasic.network.redditResponse.children.Data
import java.lang.Exception

//sealed class DataState{
//    object Loading: DataState()
//    data class Success(val data:List<Blog>):DataState()
//    data class Failure(val msg:String):DataState()
//    object Empty:DataState()
//}


sealed class DataState<out T>{

    data class Success<out T>(val data: T): DataState<T>()
    data class Error(val exception: Exception): DataState<Nothing>()
    data class ErrorUnknown(val exception: String):DataState<Nothing>()
    object Loading : DataState<Nothing>()
    object Empty:DataState<Nothing>()
}
