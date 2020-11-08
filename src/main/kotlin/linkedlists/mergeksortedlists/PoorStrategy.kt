package linkedlists.mergeksortedlists

import linkedlists.ListNode
import java.util.*


class PoorStrategy : MergeKSortedListsStrategy {
    override fun solve(nodes: Array<ListNode>): ListNode? {
        val l: MutableList<Int> = LinkedList()

        for (ln in nodes) {
            var lns: ListNode? = ln
            while (lns != null) {
                l.add(lns.value)
                lns = lns.next
            }
        }

        l.sort()

        val head = ListNode(0)
        var h: ListNode? = head
        for (i in l) {
            val t = ListNode(i)
            h!!.next = t
            h = h!!.next
        }
        h!!.next = null
        return head.next
    }

    override fun name() = "Kinda of BruteForce, should be O(N log N) complexity"

    override fun tip() = "Solution created by windliang (https://leetcode.com/problems/merge-k-sorted-lists/solution/172018)"
}