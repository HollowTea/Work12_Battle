package org.example

enum class Ammo(private val damage: Int, private val critChance: Int, private val critRate: Int) {
    SniperAmmo(65, 10, 60),
    PlazmaRifleAmmo(9, 35, 55),
    RailgunAmmo(170, 15, 100),
    PistolAmmo(8, 63, 40);

    fun getDamage(ammoClass: Ammo): Int {
        var damageLvl = ammoClass.damage
        return if (ammoClass.critChance.realizedChance()) {
            damageLvl += ammoClass.damage * ammoClass.critRate / 100
            println("Critical hit!")
            damageLvl
        } else {
            println("Successful hit.")
            damageLvl
        }
    }

}