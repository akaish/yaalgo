import linkedlists.loop.FindLoopProblem
import linkedlists.mergeksortedlists.MergeKSortedListsProblem
import linkedlists.reverse.ReverseProblem
import linkedlists.twonumbers.SumProblem

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