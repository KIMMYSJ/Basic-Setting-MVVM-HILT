package at.modoo.kbasic.network

import at.modoo.kbasic.network.redditResponse.Feed
import retrofit2.Response
import retrofit2.http.GET

interface BlogAPI {
    @GET(".json")
    suspend fun get():Response<Feed>
}