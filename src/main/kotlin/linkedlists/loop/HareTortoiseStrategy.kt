package linkedlists.loop

import linkedlists.ListNode

class HareTortoiseStrategy : FindLoopStrategy {
    override fun hasCycle(head: ListNode?): Boolean {
        if(head == null)
            return false
        var hare = head
        var tortoise = head
        while (hare != null && tortoise != null) {
            tortoise = tortoise.next
            hare = hare.next?.next
            if(hare == tortoise)
                return true
        }
        return false
    }

    override fun name() = "Hare tortoise race strategy"

    override fun tip() = "We have two pointers and different speed. If those pointers are equal - we have a loop. Otherwise - false."
}