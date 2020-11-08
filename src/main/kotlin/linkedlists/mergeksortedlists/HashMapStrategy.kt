package linkedlists.mergeksortedlists

import linkedlists.ListNode
import java.util.*

/**
 * Kinda not standard solution, that I created myself. Actually it is a sorting algorithm.
 * @author akaish
 */
class HashMapStrategy : MergeKSortedListsStrategy {
    override fun solve(nodes: Array<ListNode>): ListNode? {
        val heads = HashMap<Int, Cat>()
        val sortedCats = PriorityQueue(Comparator.comparingInt{ o: Cat -> o.value })
        nodes.forEach {
            var ls: ListNode? = it
            while (ls != null) {
                var next = ls.next
                while (next != null && next.value == ls.value) {
                    next = next.next
                }
                val existing = heads[ls.value]
                ls.next = null
                if (existing != null) {
                    ls.next = existing.head
                    existing.head = ls
                } else {
                    val newCat = Cat(ls.value)
                    newCat.head = ls
                    newCat.tail = ls
                    heads[ls.value] = newCat
                    sortedCats.add(newCat)
                }
                ls = next
            }
        }
        val cat = sortedCats.poll()
        var gg = sortedCats.poll()
        while(gg != null) {
            cat.tail?.next = gg.head
            cat.tail = gg.tail
            gg = sortedCats.poll()
        }
        return cat.head
    }

    data class Cat(
        val value: Int,
        var head: ListNode? = null,
        var tail: ListNode? = null
    )

    override fun name() = "My solution based on hash map and heap"

    override fun tip() = "Seems to be O( (N+N) log K ) where K - amount of unique ListNode values => O(N log N)"
}