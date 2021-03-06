## Примеры задач для подготовки к ТО

### linked lists:
* https://leetcode.com/problems/merge-k-sorted-lists/ Main.kt k1
* https://leetcode.com/problems/linked-list-cycle/ Main.kt k2
* https://leetcode.com/problems/add-two-numbers/ Main.kt k3
* https://leetcode.com/problems/reverse-linked-list/ Main.kt k4

### binary search:

Тут все максимально просто, бинарный поиск и в африке бинарный поиск. Последние три - поиск точки сдвига с помощью
модифицированного алгоритма бинарного поиска.
* https://leetcode.com/problems/binary-search/
* https://leetcode.com/problems/guess-number-higher-or-lower/
* https://leetcode.com/problems/search-a-2d-matrix/
* https://leetcode.com/problems/search-in-rotated-sorted-array/
* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
* https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

### hash table:

Тут тоже все просто, хэш таблицы есть хеш таблицы.
* https://leetcode.com/problems/single-number/ - решитьза O(1) по памяти

Постановка задачи выше: дан массив из n целочисленных значений. Одно из значений уникально, остальные встречаются ровно два раза.
Найти уникальное значение. Вообще, с помощью хеш таблиц за O(1) эту задачу не решить. За O(1) по памяти и O(N) по операциям решить
можно, перексорив все числа в массиве, потому что A xor A = 0, A xor 0 = A.
* https://leetcode.com/problems/two-sum/ - закидываем все в хеш таблицу, для параметра (суммы двух чисел) для каждого значения
таблицы смотрим наличие в ней числа, равного p-n
* https://leetcode.com/problems/4sum/ - это решается муторно, по факту, 2sum - частный случай 4sum, в конечном итоге все сводится
к постоянному вызову 2sum и рекурсии.
* https://leetcode.com/problems/group-anagrams/
* https://leetcode.com/problems/valid-anagram/
* https://leetcode.com/problems/find-all-anagrams-in-a-string/

Задачи на анаграммы имеют схожие решения с суммами. Но, что-то мне подсказывает, что более лучшим варинтом будет закодировать
буквы простыми числами (A - 2; B - 3; C - 5; D - 7 и т.п.) и представлять анаграммы как сумму кодированных символов, умноженных на 
число их повторений + (отдельно, не как сумма) - количество символов в строке. Тогда, к примеру, DACA = 7 + 5 + 2*2 [4] = 16 [4].
К сожалению, отсутствие нормального математического бэкграунда не дает мне возможности составить доказательство этой гипотезы.

### queue/stack:
* https://leetcode.com/problems/valid-parentheses/ - брр, берем стек и хэш таблицу, в хеш таблицу закидываем скобки,
где ключ - закрывающая скобка из пары. Затем пушим в стек символы. Если очередной символ является ключом для символа на 
вершине стека, то выполняем pop и скипаем этот элемент. Если после прогона всей строки в стеке остались значения, то
строка невалидная.

### dfs/bfs: 
* https://leetcode.com/problems/number-of-islands/ - простая задача, по идее, берем и проходимся по массиву в каком-либо 
определенном порядке, как только натыкаемся на единичку - производим поиск в ширину или до тех пор, пока его возможно 
производить, изменяя значения посещенных вершин с 1 на ноль. Каждый раз, когда мы в головном цикле натыкаемся на 1-ку, 
инкрементируем счетчик островов.  
* https://leetcode.com/problems/remove-invalid-parentheses/ - достаточно сложная проблема, 6 утра, понедельник, скипаю.
Основная сложность для меня - непонятно, как данную последовательность представить в виде графа и свести решения к поиску
в глубину или ширину.

### sort: 
* https://leetcode.com/problems/merge-intervals/ - Тут все просто. Для начала берем и отсортировываем массивы qsort'ом, затем
просто проходимся по отсортированному массиву и применяем следущий подход:
1. Если выходной массив пуст - добавляем первый элемент из массива интервалов, записываем в переменную конец интервала.
2. Если массив имеет элементы:
* A: если начало интервала больше чем переменная, то назначаем переменной значение, равное концу интервала и добавляем
в выходной массив этот элемент.
* B: если начало интервала меньше или равно значение переменной, то, в случае, если конец интервала больше переменной, то
устанавливаем значение переменной равным значению конца интервала, в противном случа - просто скипаем.

Скорость решения равна: O(N log N) qsort + O(N) перебора = O(N log N + N) = O(N log N)  

### heap/hash:
* https://leetcode.com/problems/top-k-frequent-words/
* https://leetcode.com/problems/top-k-frequent-elements/

Все просто, берем HashMap и добавляем туда значения в качестве ключей, а в качестве значения - счетчик. Если значение уже 
есть в таблице - то увеличиваем счетчик. Затем сортируем набор пар по значению и отдаем. Связка HashMap и PriorityQueue.

### two pointers:
* https://leetcode.com/problems/container-with-most-water/ - скользящее окно наоборот, устанавливаем левую и правую границу
и поочередно сближаем их, перезаписывая площадь в случае, если она увеличилась. Main.maxSquareTask()
* https://leetcode.com/problems/partition-labels/ - как решить двумя указателями - придумать не могу. Максимум, что приходит
на ум:
1. взять первый символ и найти последнее его вхождение в строку
2. взять следующий уникальный символ и повторить
Повторять до тех пор, пока в подстроке не останется новых символов.
По идее, это уже O(N^2). Уже неплохо. 
Как варинт, можно ускорить все это засчет реестра первых и последних вхождений, единоразово пройтись по строке, и сформировать
очередь (Deque), где каждый элемент это координаты первого и последнего вхождения для каждого символа.
Частичное решение в Main.longestLabels() (решение отвечает только на вопрос, сколько таких подстрок) 

### sliding window:
* https://leetcode.com/problems/sliding-window-median/
* https://leetcode.com/problems/sliding-window-maximum/
* https://leetcode.com/problems/longest-repeating-character-replacement/

Никогда ничего не писал с использованием динамических алгоритмов. Понимаю только общую суть. Первые два, по идее, решаются
с помощью priority queue. Правда, не вижу тут динамического программирования, кроме того, что присутствует скользящее окно.
Третье - хз.

### tree:
* https://leetcode.com/problems/same-tree/ - дерево является частным случаем графа. DFS и проверка значения вершин на каждом шаге.
* https://leetcode.com/problems/symmetric-tree/ - аналогично, DFS и проверка набора вершин.
* https://leetcode.com/problems/balanced-binary-tree/ - BFS по идее, но навыка не хватает по быстрому придумать норм решение, скорость n^2
* https://leetcode.com/problems/path-sum-ii/ - обход дерева, DFS

Тут конкретный пробел. По факту, знаю только две структуры на деревьях - черно-красное дерево (TreeMap) и бинарное дерево (куча) (PriorityQueue).

### greedy problems:
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ 
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

Никогда не решал NP полные задачи жадными алгоритмами. В целом, подход простой, определить оптимальную локальную стратегию
и применить её к общей задаче.
