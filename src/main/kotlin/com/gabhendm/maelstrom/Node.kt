package com.gabhendm.maelstrom

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import mu.KotlinLogging
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*


private val logger = KotlinLogging.logger {}

class Node(private var id : String = "uninitialized", val scanner : Scanner) {

    private fun initServer(message: Message) {
        logger.error { "Initializing Node ID ${message.body.nodeId}" }
        this.id = message.body.nodeId!!
        val response = Message(-1, this.id, message.src, Body("init_ok", msgId = 123, inReplyTo = message.body.msgId ))
        outputObj(response)
    }
    private fun echo(message: Message) {
        var nextId= message.body.msgId?.plus(1)
        val response = Message(-1, this.id, message.src, Body("echo_ok", echo = message.body.echo, inReplyTo = message.body.msgId, msgId = nextId))
        outputObj(response)
    }
    fun parseMessage(input: InputStream): Message {
        val messageString = BufferedReader(InputStreamReader(input)).readLine()
        logger.error("Received message: $messageString")
        return Json.decodeFromString<Message>(messageString)
    }

    fun outputObj(message: Message) {
        val messageString = Json.encodeToString(message)
        logger.error { "Replying: $messageString" }
        println(messageString)
        System.out.flush()
    }
    fun run() {
        while(true) {
            try {

                if (scanner.hasNextLine()) {
                    val input = scanner.nextLine()
                    val obj = parseMessage(input.byteInputStream());

                    when(obj.body.type) {
                        "init" -> initServer(obj)
                        "echo" -> echo(obj)
                    }
                    /*outputObj(obj)*/
                }
            } catch (e: Exception) {
                logger.error { e }

            }
        }
    }
}