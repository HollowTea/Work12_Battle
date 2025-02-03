import org.example.AbstractWeapon
import org.example.Ammo

object Weapons {

    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon(
            10, fireType = FireType.MultiShot(3), typeAmmo = Ammo.PistolAmmo) {
        }
    }

    fun createSniperRifle(): AbstractWeapon {
        return object : AbstractWeapon(2, fireType = FireType.SingleShot, typeAmmo = Ammo.SniperAmmo) {
        }
    }

    fun createRailGun(): AbstractWeapon {
        return object : AbstractWeapon(1, fireType = FireType.SingleShot, typeAmmo = Ammo.RailgunAmmo) {
        }
    }

    fun createRifle(): AbstractWeapon {
        return object : AbstractWeapon(
            22, fireType = FireType.MultiShot(5), typeAmmo = Ammo.PlazmaRifleAmmo) {
        }
    }
}