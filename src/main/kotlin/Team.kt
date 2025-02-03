import org.example.AbstractWarrior
import org.example.realizedChance

class Team(private val warriorsCount: Int, val warriorsList: MutableList<AbstractWarrior> = mutableListOf()) {

    fun teamRecruiting(): MutableList<AbstractWarrior> {
        var recruitmentCount = 0
        while (recruitmentCount != warriorsCount) {
            if (15.realizedChance()) {
                warriorsList.add(TheChosenOne())
            } else if (25.realizedChance()) {
                warriorsList.add(Spartan())
            } else if (45.realizedChance()) {
                warriorsList.add(Stormtrooper())
            } else {
                warriorsList.add(Newbie())
            }
            recruitmentCount++
        }
        return warriorsList
    }
}