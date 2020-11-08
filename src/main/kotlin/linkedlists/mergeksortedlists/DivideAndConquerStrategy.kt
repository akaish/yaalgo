package linkedlists.mergeksortedlists

import linkedlists.ListNode

class DivideAndConquerStrategy : MergeKSortedListsStrategy {

    override fun solve(nodes: Array<ListNode>): ListNode? {
        if (nodes.isEmpty()) return null
        var interval = 1
        while (interval < nodes.size) {
            var i = 0
            while (i + interval < nodes.size) {
                nodes[i] = mergeTwo(nodes[i], nodes[i + interval])
                i += interval * 2
            }
            interval *= 2
        }

        return nodes[0]
    }

    private fun mergeTwo(o1: ListNode, o2: ListNode) : ListNode {
        var a1 : ListNode? = o1
        var a2 : ListNode? = o2
        var tail = ListNode(0)
        var out = tail
        while (a1 != null && a2 != null) {
            if(a1.value < a2.value) {
                tail.next = a1
                tail = tail.next!!
                a1 = a1.next
            } else {
                tail.next = a2
                tail = tail.next!!
                a2 = a2.next
            }
        }
        if(a1 == null) {
            tail.next = a2
        }
        if(a2 == null) {
            tail.next = a1
        }
        return out.next!!
    }

    override fun name() = "Divide and conquer strategy: merging list by pairs"

    override fun tip() = "Should be O ( N log K ) speed where K is array size"
}