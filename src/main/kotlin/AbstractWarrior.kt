package org.example

import NoAmmoException
import Warrior

abstract class AbstractWarrior(
    private val maxHP: Int,
    override val evadeChance: Int,
    private val hitAccuracy: Int,
    private val weapon: AbstractWeapon,
    private var currentHP: Int = maxHP
) : Warrior {

    override fun takeDamage(damageCount: Int) {
        currentHP -= damageCount
        isKilled = currentHP <= 0
    }

    override fun attack(enemy: Warrior) {
        try {
            println("--")
            println("Trying attack")
            println("--")
            var damage = 0
            weapon.getAmmo().stack.forEach {
                if (!hitAccuracy.realizedChance()) {
                    println("Missed shot!")
                } else if (enemy.evadeChance.realizedChance()) {
                    println("Enemy dodged!")
                } else {
                    damage += it.getDamage(it)
                }
            }
            println("Attack is done. Total damage to enemy = $damage HP.")
            enemy.takeDamage(damage) //вынес за цикл, тк в задании просят рассчитать суммарный урон и затем нанести его (видимо целиком)
        } catch (t: NoAmmoException) {
            weapon.reload()
            println("---")
            println("No ammo.. Reloaded!")
            println("---")
        }
        finally {
            println("This move is done.")
        }
    }
}