package linkedlists.mergeksortedlists

import Solution
import linkedlists.ListNode

interface MergeKSortedListsStrategy : Solution {
    fun solve(nodes: Array<ListNode>): ListNode?
}