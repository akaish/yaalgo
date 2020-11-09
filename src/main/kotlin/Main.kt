import linkedlists.loop.FindLoopProblem
import linkedlists.mergeksortedlists.MergeKSortedListsProblem
import linkedlists.reverse.ReverseProblem
import linkedlists.twonumbers.SumProblem
import java.lang.Integer.min
import java.lang.Math.pow
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
        maxSquareTask()
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
    // Wrong need another guess
//    val task = intArrayOf(1,8,6,2,5,4,8,3,7)
//
//    var best = 0
//
//    var l = 0
//    for(r in task.indices) {
//        val thisSquare = square(task[l], task[r], r-l)
//        if(thisSquare > best) {
//            best = thisSquare
//        } else {
//            while (square(task[l], task[r], r - l) < best && r != l) {
//                l++
//            }
//        }
//        println("$l $r")
//    }
//    println(best)
}

private fun square(lV: Int, rV: Int, lenght: Int) = min(lV, rV) * lenght