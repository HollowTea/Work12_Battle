import org.example.AbstractWarrior
import org.example.AbstractWeapon

class Spartan(
    maxHP: Int = 100,
    evadeChance: Int = 17,
    hitAccuracy: Int = 92,
    weapon: AbstractWeapon = Weapons.createSniperRifle()
) :
    AbstractWarrior(maxHP, evadeChance, hitAccuracy, weapon) {
    override var isKilled: Boolean = false
}