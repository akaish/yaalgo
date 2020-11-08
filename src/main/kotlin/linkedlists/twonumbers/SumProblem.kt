package linkedlists.twonumbers

import Problem
import linkedlists.ListNode
import linkedlists.ListNode.Companion.fromVarargs
import linkedlists.ListNode.Companion.nodeToString

class SumProblem : Problem {
    override fun problem() = "You are given two non-empty linked lists representing two non-negative integers. The digits are stored " +
            "in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.\n" +
            "You may assume the two numbers do not contain any leading zero, except the number 0 itself."

    override fun source() = "https://leetcode.com/problems/add-two-numbers/"

    override fun name() = "Sum two liked lists"

    override fun run() {
        val suppliers = listOf(
            Pair(fromVarargs(2,4,3), fromVarargs(5,6,4)),
            Pair(fromVarargs(2,4,3), null),
            Pair(null, fromVarargs(5,6,4)),
            Pair(fromVarargs(0), fromVarargs(0)),
            Pair(fromVarargs(9,9,9,9,9,9,9), fromVarargs(9,9,9,9))
        )
        val strategy : SumStrategy = SumStrategyImpl()
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

    private fun solveWith(supplier: Pair<ListNode?, ListNode?>, solution: SumStrategy) {
        println("Solving task '${nodeToString(supplier.first)} + ${nodeToString(supplier.second)}' with '${solution.name()}'")
        val result = solution.sum(supplier.first, supplier.second)
        println("Result: ${nodeToString(result)}")
    }
}