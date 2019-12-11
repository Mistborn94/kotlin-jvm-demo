package org.example

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class DemoKtTest {

    private val sampleInput = """
        Step C must be finished before step A can begin.
        Step C must be finished before step F can begin.
        Step A must be finished before step B can begin.
        Step A must be finished before step D can begin.
        Step B must be finished before step E can begin.
        Step D must be finished before step E can begin.
        Step F must be finished before step E can begin.
    """.trimIndent()

    @Test
    fun solveSampleInput() {
        assertEquals("CABDFE", solve(sampleInput.lines()))
    }

    @Test
    fun solveActualInput() {
        val inputFile = File("src/main/resources/input.txt")
        assertEquals("PFKQWJSVUXEMNIHGTYDOZACRLB", solve(inputFile.readLines()))
    }
}