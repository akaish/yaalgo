package linkedlists.reverse

import Problem
import linkedlists.ListNode

class ReverseProblem : Problem {
    override fun problem() = "Reverse a singly linked list.\n" +
            "Example:\n" +
            "Input: 1->2->3->4->5->NULL\n" +
            "Output: 5->4->3->2->1->NULL"

    override fun source() = "https://leetcode.com/problems/reverse-linked-list/"

    override fun name() = "Reverse linked list"

    override fun run() {
        val suppliers = listOf(ListNode.fromVarargs(1, 2, 3, 4, 5), null, ListNode.fromVarargs(1))
        val strategy : ReverseStrategy = ReverseStrategyImpl()
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

    private fun solveWith(supplier: ListNode?, solution: ReverseStrategy) {
        println("Solving task '${ListNode.nodeToString(supplier)}' with '${solution.name()}'")
        println("Result: ${ListNode.nodeToString(solution.reverse(supplier))}")
    }
}