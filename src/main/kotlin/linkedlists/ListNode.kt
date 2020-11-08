package linkedlists

import java.lang.StringBuilder

class ListNode(var value: Int, var next: ListNode? = null) {

    companion object {

        fun fromVarargs(vararg values: Int) = fromArray(values)

        fun fromArray(values: IntArray) : ListNode {
            require(values.isNotEmpty())
            var node : ListNode? = null
            values.reversed().forEach {
                val newNode = ListNode(it)
                newNode.next = node
                node = newNode
            }
            return node!!
        }

        fun printNode(label: String, node: ListNode?) {
            println("Printing node $label: ${ListNode.nodeToString(node)}")
        }

        fun nodeToString(node: ListNode?) : String {
            var cn: ListNode? = node
            val out = StringBuilder()
            if (node != null) while (cn != null) {
                out.append(" ${cn.value} ")
                cn = cn.next
            } else {
                return "NULL"
            }
            return out.toString()
        }
    }
}