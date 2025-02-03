import org.example.AbstractWarrior

sealed class BattleState {

    data object BattleProgress : BattleState() {
        fun battleProgress(firstTeam: MutableList<AbstractWarrior>, secondTeam: MutableList<AbstractWarrior>) : Boolean {
            println("----------------------------------")
            println("Current Good guys team number - ${firstTeam.size}.")
            println("----------------------------------")
            println("Current Bad Asses team number - ${secondTeam.size}.")
            println("----------------------------------")
            return false
        }
    }

    data object FirstTeamWin : BattleState() {
        fun firstTeamWins(): Boolean {
            println("=============================")
            println("Good guys wins. Happy end!")
            println("=============================")
            return true
        }
    }

    data object SecondTeamWin : BattleState() {
        fun secondTeamWins(): Boolean {
            println("=============================")
            println("Bad Asses wins for now. Lets wait for another battle...")
            println("=============================")
            return true
        }
    }

    data object Draw : BattleState() {
        fun battleDraw(): Boolean {
            println("=============================")
            println("Oh, its a draw!")
            println("=============================")
            return true
        }
    }

}
