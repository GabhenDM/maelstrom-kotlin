package com.gabhendm.maelstrom

import java.util.Scanner
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val node = Node("1", scanner);
    try {
        node.run();
    } catch (e : Exception) {
        exitProcess(1);
    }
}