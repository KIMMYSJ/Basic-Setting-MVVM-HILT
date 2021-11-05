package at.modoo.kbasic.network

import at.modoo.kbasic.model.Blog
import at.modoo.kbasic.network.redditResponse.Feed
import at.modoo.kbasic.network.redditResponse.children.Data
import at.modoo.kbasic.utility.EntityMapper
import javax.inject.Inject

object NetworkMapper :EntityMapper<Data, Blog> {
    override fun mapFromNetworkToModel(networkEntity: Data): Blog {
        return Blog(
            title= networkEntity.title,
            author = networkEntity.author,
            thumbnail = networkEntity.thumbnail,
            id = networkEntity.id
        )
    }

    override fun mapFromModelToNetwork(model: Blog): Data {
        return Data(
            title= model.title,
            author = model.author,
            thumbnail = model.thumbnail,
            id = model.id
        )
    }

    fun mapFromResponse(entities: Feed):List<Blog>{

        return entities.data.children.map { it ->
            mapFromNetworkToModel(it.data)

        }
    }

}