package linkedlists.loop

import Solution
import linkedlists.ListNode

interface FindLoopStrategy : Solution {
    fun hasCycle(head: ListNode?): Boolean
}