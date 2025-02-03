import org.example.AbstractWarrior
import org.example.AbstractWeapon

class TheChosenOne(
    maxHP: Int = 200,
    evadeChance: Int = 25,
    hitAccuracy: Int = 97,
    weapon: AbstractWeapon = Weapons.createRailGun(),
) :
    AbstractWarrior(maxHP, evadeChance, hitAccuracy, weapon) {
    override var isKilled: Boolean = false
}