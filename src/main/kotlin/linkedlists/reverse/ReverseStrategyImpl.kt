package linkedlists.reverse

import linkedlists.ListNode
import java.util.ArrayDeque

class ReverseStrategyImpl : ReverseStrategy {

    override fun reverse(head: ListNode?): ListNode? {
        if(head == null) return null
        val stack = ArrayDeque<ListNode>()
        var tmp : ListNode? = head
        while(tmp != null) {
            stack.push(tmp)
            tmp = tmp.next
        }
        val out = stack.pop()
        var tail : ListNode? = out
        while (stack.isNotEmpty()) {
            tail?.next = stack.pop()
            tail = tail?.next
        }
        tail?.next = null
        return out
    }

    override fun name() = "Stack based reversing"

    override fun tip() = "Solutions at leetcode are not interesting, iteration is simple and I don't like recursive approach"
}