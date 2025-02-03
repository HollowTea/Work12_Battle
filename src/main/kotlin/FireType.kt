sealed class FireType {
    data object SingleShot : FireType()
    data class MultiShot(val multiShotSize: Int) : FireType()
}
