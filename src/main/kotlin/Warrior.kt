interface Warrior {
    var isKilled : Boolean
    val evadeChance: Int

    fun attack(enemy: Warrior)

    fun takeDamage(damageCount: Int)
}