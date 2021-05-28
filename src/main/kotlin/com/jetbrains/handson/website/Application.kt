package com.jetbrains.handson.website

import freemarker.cache.*
import freemarker.core.HTMLOutputFormat
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.html.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.*
import io.ktor.request.receiveParameters
import io.ktor.response.*
import io.ktor.routing.*
import com.api.igdb.*
import kotlinx.html.*
import org.json.JSONArray
import org.json.JSONObject


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
    }
    println(Question.testRequest())

    routing {
        static("/static"){
            resources("files")
        }
        get("/") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("entries" to blogEntries), ""))
        }
        post("/submit") {
            val params = call.receiveParameters()
            val output = Question.testRequest()
            val json =  JSONArray(output)
            val headline = params["headline"] ?: return@post call.respond(HttpStatusCode.BadRequest)
            val body = params["body"] ?: return@post call.respond(HttpStatusCode.BadRequest)
            val headline1 = json.getJSONObject(0)
            var headline2 = headline1.getInt("id")
            val s = String.format("%d", headline2)
            val body1 = headline1.getString("name")
            val newEntry = BlogEntry(s, body1)
            blogEntries.add(0, newEntry)
            // TODO: send a status page to the user
            call.respond(FreeMarkerContent("entry.ftl", mapOf("entries" to blogEntries), ""))
            
        }
    }

}
