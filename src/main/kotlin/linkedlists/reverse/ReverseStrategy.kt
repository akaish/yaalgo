package linkedlists.reverse

import Solution
import linkedlists.ListNode

interface ReverseStrategy : Solution {
    fun reverse(head: ListNode?) : ListNode?
}