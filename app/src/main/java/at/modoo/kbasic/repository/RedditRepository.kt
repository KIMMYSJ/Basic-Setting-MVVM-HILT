package at.modoo.kbasic.repository

import at.modoo.kbasic.model.Blog
import at.modoo.kbasic.network.BlogAPI
import at.modoo.kbasic.network.NetworkMapper
import at.modoo.kbasic.utility.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class RedditRepository
@Inject
constructor(private val blogAPI: BlogAPI) {
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)

        try {
            val retrofitBlogs = blogAPI.get()
            if(retrofitBlogs.isSuccessful)retrofitBlogs.body()?.let { emit(DataState.Success(NetworkMapper.mapFromResponse(it))) }
            else emit(DataState.ErrorUnknown(retrofitBlogs.errorBody()?.toString()?:"unknown"))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }.flowOn(Dispatchers.IO)

}
