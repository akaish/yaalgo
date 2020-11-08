package linkedlists.loop

import Problem
import linkedlists.ListNode

class FindLoopProblem : Problem {
    override fun problem() = "Given head, the head of a linked list, determine if the linked list has a cycle in it.\n" +
            "There is a cycle in a linked list if there is some node in the list that can be reached again by continuously \n" +
            "following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter."

    override fun source() = "https://leetcode.com/problems/linked-list-cycle/"

    override fun name() = "Find loop in a linked list"

    override fun run() {
        val suppliers = listOf(::supplyHasLoop, ::supplyNoLoop)
        val strategy : FindLoopStrategy = HareTortoiseStrategy()
        println()
        println()
        println("-------------------------------------------------------------")
        println(strategy.name())
        println(strategy.tip())
        println("-------------------------------------------------------------")
        suppliers.forEach { supplier ->
            println("=============================================================")
            solveWith(supplier, strategy)
        }
    }

    private fun solveWith(supplier: () ->  Pair<Boolean, ListNode>, solution: FindLoopStrategy) {
        val task = supplier.invoke()
        println("Solving task 'loop = ${task.first}' with '${solution.name()}'")
        val result = solution.hasCycle(task.second)
        println("Result: loop ${if(result) "" else "not "} found")
    }

    private fun supplyHasLoop() : Pair<Boolean, ListNode> {
        val loop = ListNode(5)
        val out = ListNode(1, ListNode(2, ListNode(3, ListNode(4, loop))))
        loop.next = ListNode(1, ListNode(2, ListNode(3, ListNode(4, loop))))
        return Pair(true, out)
    }

    private fun supplyNoLoop() : Pair<Boolean, ListNode> = Pair(false,
        ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))
    )
}