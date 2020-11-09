import linkedlists.loop.FindLoopProblem
import linkedlists.mergeksortedlists.MergeKSortedListsProblem
import linkedlists.reverse.ReverseProblem
import linkedlists.twonumbers.SumProblem
import java.lang.Integer.min
import java.lang.Math.pow
import java.util.*
import kotlin.collections.LinkedHashMap
import kotlin.math.max

val problems = LinkedHashMap<String, () -> Problem>().apply {
    put("k1") { MergeKSortedListsProblem() }
    put("k2") { FindLoopProblem() }
    put("k3") { SumProblem() }
    put("k4") { ReverseProblem() }
}

fun main(vararg p: String) {
    require(p.size == 1) { "Need one and only one param" }
    if(p[0] == "h") {
        problems.entries.forEach {
            println("${it.key} => ${it.value.invoke().name()}")
        }
        return
    }
    if(p[0] == "mx") {
        longestLabels()
        return
    }
    val problem = problems[p[0]]
    if(problem == null) {
        println("Unknown problem")
    } else {
        println()
        val problemImpl = problem.invoke()
        println("Name: ${problemImpl.name()}")
        println("Desc: ${problemImpl.problem()}")
        println("Source: ${problemImpl.source()}")
        println()
        problemImpl.run()
    }
}

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 * the x-axis forms a container, such that the container contains the most water.
 * Notice that you may not slant the container.
 *
 * Source: https://leetcode.com/problems/container-with-most-water/
 */
fun maxSquareTask() {
    // task [1,8,6,2,5,4,8,3,7]
    // expected = 49
    val task = intArrayOf(1,8,6,2,5,4,8,3,7)
    var maxSum = 0
    var l = 0
    var r = (task.size - 1)
    while(r != l) {
        maxSum = max(maxSum, square(task[l], task[r], r-l))
        if(task[r] > task[l])
            l++
        else r--
    }
    println(maxSum)
}

private fun square(lV: Int, rV: Int, lenght: Int) = min(lV, rV) * lenght

fun longestLabels() {
    //val str = "ababcbacadefegdehijhklij"
    val str = "1234567675"
    val strMap = LinkedHashMap<Char, MutableIntPair>()
    var position = 0
    str.forEach {
        if(strMap.containsKey(it)) {
            strMap[it] = strMap[it]!!.copy(second = position)
        } else {
            strMap[it] = MutableIntPair(position, position)
        }
        position++
    }
    var result = 1
    var lastEnd = 0
    strMap.values.forEach {
        if(it.first > lastEnd) {
            result++
        }
        lastEnd = max(it.second, lastEnd)
    }
    println(result)
}

data class MutableIntPair(var first: Int, var second: Int)

