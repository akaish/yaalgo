package linkedlists.mergeksortedlists

import Problem
import linkedlists.ListNode
import linkedlists.ListNode.Companion.fromArray
import linkedlists.ListNode.Companion.printNode
import java.util.*


class MergeKSortedListsProblem : Problem {

    override fun problem() = "You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.\n" +
            "Merge all the linked-lists into one sorted linked-list and return it.\n" +
            "Example:\n" +
            "Input: lists = [[1,4,5],[1,3,4],[2,6]]\n" +
            "Output: [1,1,2,3,4,4,5,6]"

    override fun source() = "https://leetcode.com/problems/merge-k-sorted-lists/"
    override fun name() = "Merge k sorted linked lists"

    override fun run() {
        val suppliers = listOf(::taskSupplierOne, ::taskSupplierTwo, ::taskSupplierThree)
        val solutions = listOf(PoorStrategy(), DivideAndConquerStrategy(), HashMapStrategy())
        solutions.forEach {
            println()
            println()
            println("-------------------------------------------------------------")
            println(it.name())
            println(it.tip())
            println("-------------------------------------------------------------")
            suppliers.forEach { supplier ->
                println("=============================================================")
                solveWith(supplier, it)
            }
        }
    }

    private fun solveWith(supplier: () -> Triple<Array<ListNode>, Boolean, String>, solution: MergeKSortedListsStrategy) {
        val task = supplier.invoke()
        println("Solving task '${task.third}' with '${solution.name()}'")
        if(task.second) {
            println("Task: too big to be printed")
        } else {
            println("Task: ")
            task.first.forEachIndexed { index, listNode ->
                printNode("index[$index]", listNode)
            }
        }
        val nanosStart = System.nanoTime()
        val result = solution.solve(task.first)
        println("Solved in ${System.nanoTime() - nanosStart}")
        println(if(task.second) "Result is too big to be printed" else printNode("Result", result))
    }

    private fun taskSupplierOne(): Triple<Array<ListNode>, Boolean, String> = Triple(
        Array(3) {
            when (it) {
                0 -> fromArray(intArrayOf(1, 4, 5))
                1 -> fromArray(intArrayOf(1, 3, 4))
                else -> fromArray(intArrayOf(2, 6))
            }
        }, false, "Simple case [[1,4,5],[1,3,4],[2,6]]"
    )

    private fun taskSupplierTwo(): Triple<Array<ListNode>, Boolean, String> = Triple(
        genTask(200, 1000, 100), true, "Big amount of repetitions (200 nodes, 1000 node size, increment each 20 elements)"
    )

    private fun taskSupplierThree(): Triple<Array<ListNode>, Boolean, String> = Triple(
        genTask(10, 20000, 1), true, "Less amount of repetitions (10 nodes, 20000 node size, increment on each element)"
    )

    private fun genTask(size: Int, nodeSize: Int, nodeFactor: Int): Array<ListNode> = LinkedList<ListNode>().apply {
        require(size >= 0)
        require(nodeSize > 0)
        require(nodeFactor > 0)
        for(i in 0..size) {
            add(genNode(nodeSize, nodeFactor))
        }
    }.toTypedArray()

    private fun genNode(length: Int, factor: Int) : ListNode {
        val h1 = ListNode(1)
        var h1Tail = h1
        var value = 1
        for (i in 0..length) {
            val tmp = ListNode(value)
            h1Tail.next = tmp
            h1Tail = tmp
            if (i % factor == 0) value++
        }
        return h1
    }
}