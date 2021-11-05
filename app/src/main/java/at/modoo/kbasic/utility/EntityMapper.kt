package at.modoo.kbasic.utility

import at.modoo.kbasic.network.redditResponse.Feed

interface EntityMapper<NetworkEntity,Model> {
    fun mapFromNetworkToModel(networkEntity:NetworkEntity):Model
    fun mapFromModelToNetwork(model:Model):NetworkEntity
}