import org.example.AbstractWarrior
import org.example.AbstractWeapon

class Newbie(
    maxHP: Int = 55,
    evadeChance: Int = 6,
    hitAccuracy: Int = 70,
    weapon: AbstractWeapon = Weapons.createPistol(),
) :
    AbstractWarrior(maxHP, evadeChance, hitAccuracy, weapon) {
    override var isKilled: Boolean = false
}