package org.example

import FireType
import NoAmmoException
import Stack

abstract class AbstractWeapon(
    private var maxMagazineSize: Int,
    var fireType: FireType,
    private var ammoMagazine: Stack<Ammo> = Stack(),
   // var ammoPresence: Boolean = false,
    var typeAmmo: Ammo
) {

    private fun createAmmo(): Ammo {
        return when (typeAmmo) {
            Ammo.PistolAmmo -> Ammo.PistolAmmo
            Ammo.PlazmaRifleAmmo -> Ammo.PlazmaRifleAmmo
            Ammo.RailgunAmmo -> Ammo.RailgunAmmo
            Ammo.SniperAmmo -> Ammo.SniperAmmo
        }
    }

    fun reload(): Stack<Ammo> {
        while (ammoMagazine.stack.size != maxMagazineSize) {
            ammoMagazine.push(createAmmo())
        }
        return ammoMagazine
    }

    fun getAmmo(): Stack<Ammo> {
        val takenAmmo: Stack<Ammo> = Stack()
        when (fireType) {
            is FireType.MultiShot -> {
                var passedAmmo = 0
                if (ammoMagazine.stack.size < (fireType as FireType.MultiShot).multiShotSize) {
                    throw NoAmmoException()
                }
                else {
                    while (passedAmmo < (fireType as FireType.MultiShot).multiShotSize) {
                        ammoMagazine.pop()!!
                        takenAmmo.push(typeAmmo)
                        passedAmmo++
                    }
                }
            }
            is FireType.SingleShot -> {
                if (ammoMagazine.stack.size != 0) {
                    ammoMagazine.pop()?.let { takenAmmo.push(it) }
                }
                else {
                    throw NoAmmoException()
                }
            }
        }
        return takenAmmo
    }
}