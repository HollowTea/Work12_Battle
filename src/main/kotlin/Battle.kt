package org.example

import Team

class Battle(
    private val firstTeam: Team,
    private val secondTeam: Team,
    private var battleEnds: Boolean = false
) {
    private fun getBattleState(): Boolean {
        return if (firstTeam.warriorsList.size == 0 && secondTeam.warriorsList.size != 0) {
            BattleState.SecondTeamWin.secondTeamWins()
        } else if (secondTeam.warriorsList.size == 0 && firstTeam.warriorsList.size != 0) {
            BattleState.FirstTeamWin.firstTeamWins()
        } else if (secondTeam.warriorsList.size == 1 && firstTeam.warriorsList.size == 1) {
            BattleState.Draw.battleDraw()
        } else {
            BattleState.BattleProgress.battleProgress(firstTeam.warriorsList, secondTeam.warriorsList)
        }
    }

    fun battleIteration() {
        println("The battle starts now!")
        while (!battleEnds) {
            firstTeam.warriorsList.shuffle()
            firstTeam.warriorsList[0].attack(secondTeam.warriorsList[0])
            if (secondTeam.warriorsList[0].isKilled) {
                secondTeam.warriorsList.removeAt(0)
                println("Good Guys warrior kill Bad Asses warrior.")
            }
            if (secondTeam.warriorsList.size != 0) {
                secondTeam.warriorsList.shuffle()
                secondTeam.warriorsList[0].attack(firstTeam.warriorsList[0])
                if (firstTeam.warriorsList[0].isKilled) {
                    firstTeam.warriorsList.removeAt(0)
                    println("Bad Asses team warrior kill Good Guys warrior.")
                }
            }
            battleEnds = getBattleState()
        }
    }
}