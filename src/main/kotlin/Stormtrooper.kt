import org.example.AbstractWarrior
import org.example.AbstractWeapon

class Stormtrooper(
    maxHP: Int = 75,
    evadeChance: Int = 12,
    hitAccuracy: Int = 85,
    weapon: AbstractWeapon = Weapons.createRifle()
) :
    AbstractWarrior(maxHP, evadeChance, hitAccuracy, weapon) {
    override var isKilled: Boolean = false
}