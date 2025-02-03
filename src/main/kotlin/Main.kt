package org.example

import Team
import kotlin.random.Random

fun main() {
    println("Input count of the first team:")
    var firstTeamCount = readln().toInt()
    if (firstTeamCount <= 0) {
        do {
            println("Error, the warriors count need to be >= 1. Repeat count input:")
            firstTeamCount = readln().toInt()
        } while (firstTeamCount <= 0)
    }

    println("Input count of the second team:")
    var secondTeamCount = readln().toInt()
    if (secondTeamCount <= 0) {
        do {
            println("Error, the warriors count need to be >= 1. Repeat count input:")
            secondTeamCount = readln().toInt()
        } while (secondTeamCount <= 0)
    }

    val goodGuys = Team(firstTeamCount)
    goodGuys.teamRecruiting()
    val badAsses = Team(secondTeamCount)
    badAsses.teamRecruiting()

    Battle(goodGuys,badAsses).battleIteration()
}

fun Int.realizedChance(): Boolean {
    val randomInt = Random.nextInt(1,100)
    return randomInt in 1.. this
}