class Stack<T> {

    var stack: MutableList<T> = mutableListOf()

    fun push(item: T) {
        stack += item
    }

    fun pop(): T? {
        return if (stack.size == 0) {
            null
        } else {
            val listElement = stack.last()
            stack.removeLast()
            listElement
        }
    }

  /*  fun isNotEmpty(): Boolean {
        return stack.size != 0
    } */
}