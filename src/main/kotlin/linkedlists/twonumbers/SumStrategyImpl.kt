package linkedlists.twonumbers

import linkedlists.ListNode

class SumStrategyImpl : SumStrategy {

    /**
     * Actually, I have no idea how to make any elegant solution, just summing all
     *
     */
    override fun sum(a: ListNode?, b: ListNode?): ListNode? {
        if(a == null) return b
        if(b == null) return a
        var a1 = a
        var b1 = b
        val out = ListNode(0)
        var tail : ListNode? = out
        var carry = 0
        while (a1 != null || b1 != null) {
            val sum = (a1?.value ?: 0) + (b1?.value ?: 0) + carry
            carry = sum / 10
            tail?.next = ListNode(sum % 10)
            tail = tail?.next
            a1?.let { a1 = it.next }
            b1?.let { b1 = it.next }
        }
        if(carry > 0)
            tail?.next = ListNode(carry)
        return out.next
    }

    override fun name() = "Summing all"

    override fun tip() = "Just summing values"

}