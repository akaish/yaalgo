package linkedlists.twonumbers

import Solution
import linkedlists.ListNode

interface SumStrategy : Solution {
    fun sum(a: ListNode?, b: ListNode?) : ListNode?
}