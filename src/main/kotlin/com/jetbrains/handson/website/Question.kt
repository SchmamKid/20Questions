
package com.jetbrains.handson.website
import com.api.igdb.apicalypse.APICalypse
import com.api.igdb.apicalypse.Sort
import com.api.igdb.exceptions.RequestException
import com.api.igdb.request.IGDBWrapper
import com.api.igdb.request.IGDBWrapper.apiJsonRequest
import com.api.igdb.request.TwitchAuthenticator
import com.api.igdb.utils.*
import com.api.igdb.request.games
import com.api.igdb.request.jsonGames
import proto.Game

object Question {
    fun testRequest(): String {

        val token =
            TwitchAuthenticator.requestTwitchToken("7txv9blv7ojfoa07i9vchha77pg5ce", "b54a532g0mivuj9sdv3xcpibgjno4h")
        TwitchAuthenticator.twitchToken
        TwitchAuthenticator.twitchToken?.let {
            IGDBWrapper.setCredentials(
                "7txv9blv7ojfoa07i9vchha77pg5ce",
                it.access_token
            )
        }
        /*(val json: String = apiJsonRequest(Endpoints.GAMES, "fields *;")
        val apicalypse = APICalypse().fields("*").sort("release_dates.date", Sort.DESCENDING)

        try {
            val json: String = apiJsonRequest(Endpoints.GAMES, "fields *;")
            return json
        } catch (e: RequestException) {
            println("Didnt Work")
            //val other: List<Game> = emptyList()
            return ""
        }
        */
        println(apiJsonRequest(Endpoints.GAMES, "fields *;"))
        val apicalypse = APICalypse().fields("name").search("Halo").where("platforms = 49");

        val query = apicalypse.buildQuery()
        println(query)
        val json: String = apiJsonRequest(Endpoints.GAMES, query)
        return json
        /*return IGDBWrapper.games(
            APICalypse()
                .fields("*")
                .exclude("*")
                .limit(10)
                .offset(0)
                .search("Halo")
                .sort("release_dates.date", Sort.ASCENDING)
                .where("platforms = 48")
        )*/
    }
}