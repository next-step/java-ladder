package ladder.view

import java.util.Scanner

object InputView {
    private val scanner = Scanner(System.`in`)

    fun getInputString(message: String): String {
        println(message)
        return scanner.next()
    }

    fun getInputNumber(message: String): Int {
        println(message)
        return scanner.nextInt()
    }
}
