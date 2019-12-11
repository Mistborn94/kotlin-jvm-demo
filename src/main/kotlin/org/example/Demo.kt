package org.example

val pattern = "Step ([A-Z]) must be finished before step ([A-Z]) can begin\\.".toRegex()

class Step(val name: String) {
    val prerequisites = mutableSetOf<Step>()

    fun isReady(completeSteps: Collection<Step>): Boolean {
        return prerequisites.all { it in completeSteps }
    }
}

fun solve(instructions: List<String>): String {
    val nodeMap = buildNodeMap(instructions)

    val incompleteSteps = nodeMap.values.toSortedSet(Comparator.comparing<Step, String> { it.name })
    val completeSteps = mutableListOf<Step>()

    while (!incompleteSteps.isEmpty()) {
        val currentStep = incompleteSteps.first { it.isReady(completeSteps) }
        incompleteSteps.remove(currentStep)
        completeSteps.add(currentStep)
    }

    return completeSteps.joinToString(separator = "") { it.name }
}

private fun buildNodeMap(instructions: List<String>): MutableMap<String, Step> {
    val nodeMap = mutableMapOf<String, Step>()

    instructions.forEach {
        val (first, second) = pattern.matchEntire(it)!!.destructured
        val step1 = nodeMap.getOrPut(first) { Step(first) }
        val step2 = nodeMap.getOrPut(second) { Step(second) }
        step2.prerequisites.add(step1)
    }
    return nodeMap
}
