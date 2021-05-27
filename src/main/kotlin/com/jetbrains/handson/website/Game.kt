package com.jetbrains.handson.website
import com.api.igdb.*
import com.api.igdb.apicalypse.APICalypse
import com.api.igdb.apicalypse.Sort
import com.api.igdb.request.IGDBWrapper
import com.api.igdb.request.IGDBWrapper.apiJsonRequest
import com.api.igdb.request.TwitchAuthenticator
import com.api.igdb.request.games
import proto.Game

class Game {
   /* public fun testRequest(): APICalypse {
        val token = TwitchAuthenticator.requestTwitchToken("7txv9blv7ojfoa07i9vchha77pg5ce", "b54a532g0mivuj9sdv3xcpibgjno4h")
        TwitchAuthenticator.twitchToken
        IGDBWrapper.setCredentials("7txv9blv7ojfoa07i9vchha77pg5ce", TwitchAuthenticator.twitchToken.access_token)
        val apicalypse = APICalypse()
            .fields("*")
            .exclude("*")
            .limit(10)
            .offset(0)
            .search("Halo")
            .sort("release_dates.date", Sort.ASCENDING)
            .where("platforms = 48")
        return apicalypse
    }
    */

}