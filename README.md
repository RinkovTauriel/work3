__**Рафиков Роман Викторович УИБО-14-24**__
__________________________________________________________


Алгоритмы сортировки

Сортировка выбором (Selection Sort)

Алгоритм последовательного нахождения минимальных элементов с их перемещением в начало массива.

#include <vector>
#include <algorithm>
using namespace std;

void selectionSort(vector<int>& data) {
    for (size_t current = 0; current < data.size() - 1; current++) {
        size_t minPos = current;
        for (size_t next = current + 1; next < data.size(); next++) {
            if (data[next] < data[minPos]) {
                minPos = next;
            }
        }
        if (minPos != current) {
            swap(data[current], data[minPos]);
        }
    }
}
Особенности алгоритма:

· На каждой итерации находится наименьший элемент в необработанной части
· Обнаруженный минимум помещается на текущую позицию
· Отсортированный сегмент постепенно расширяется слева направо

Эффективность: O(n²) для всех сценариев работы

 

Сортировка обменом (Bubble Sort)

Метод последовательного сравнения и обмена соседних элементов.

def bubble_sort(collection):
    items = collection[:]
    length = len(items)
    
    for i in range(length):
        swapped = False
        for j in range(0, length - i - 1):
            if items[j] > items[j + 1]:
                items[j], items[j + 1] = items[j + 1], items[j]
                swapped = True
        if not swapped:
            break
    return items
Особенности алгоритма:

· Попарное сравнение соседних элементов
· Крупные элементы постепенно перемещаются к концу массива
· Оптимизация: досрочное завершение при отсутствии обменов

Эффективность: O(n²) в стандартном случае, O(n) для упорядоченных данных

 

Сортировка вставками (Insertion Sort)

Поэтапное построение упорядоченной последовательности.

void insertionSort(vector<int>& values) {
    for (size_t i = 1; i < values.size(); i++) {
        int key = values[i];
        int j = i - 1;
        
        while (j >= 0 && values[j] > key) {
            values[j + 1] = values[j];
            j--;
        }
        values[j + 1] = key;
    }
}
Особенности алгоритма:

· Каждый новый элемент помещается в правильную позицию отсортированной части
· Элементы большие ключа сдвигаются вправо
· Эффективен для частично упорядоченных массивов

Эффективность: O(n²) в общем случае, O(n) для упорядоченных данных

 

Сортировка слиянием (Merge Sort)

Рекурсивное разделение и объединение с упорядочиванием.

vector<int> merge(const vector<int>& left, const vector<int>& right) {
    vector<int> merged;
    size_t i = 0, j = 0;
    
    while (i < left.size() && j < right.size()) {
        if (left[i] <= right[j]) {
            merged.push_back(left[i++]);
        } else {
            merged.push_back(right[j++]);
        }
    }
    
    while (i < left.size()) merged.push_back(left[i++]);
    while (j < right.size()) merged.push_back(right[j++]);
    
    return merged;
}

vector<int> mergeSort(const vector<int>& items) {
    if (items.size() <= 1) return items;
    
    size_t mid = items.size() / 2;
    vector<int> left(items.begin(), items.begin() + mid);
    vector<int> right(items.begin() + mid, items.end());
    
    return merge(mergeSort(left), mergeSort(right));
}
Особенности алгоритма:

· Рекурсивное деление на подмассивы
· Слияние с одновременным упорядочиванием
· Гарантированная стабильность и предсказуемость

Эффективность: O(n log n) для всех случаев

 

Сортировка Шелла (Shellsort)

Улучшенная версия сортировки вставками с переменным шагом.

def shell_sort(elements):
    arr = elements.copy()
    n = len(arr)
    gap = n // 2
    
    while gap > 0:
        for i in range(gap, n):
            temp = arr[i]
            j = i
            while j >= gap and arr[j - gap] > temp:
                arr[j] = arr[j - gap]
                j -= gap
            arr[j] = temp
        gap //= 2
    return arr
Особенности алгоритма:

· Сравнение элементов на возрастающих расстояниях
· Постепенное уменьшение интервала сравнения
· Эффективен для средних объемов данных

Эффективность: O(n²) в худшем случае, O(n log²n) в среднем
 

Быстрая сортировка (Quick Sort)

Эффективный алгоритм на основе стратегии "разделяй и властвуй".

int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[i + 1], arr[high]);
    return i + 1;
}

void quickSort(vector<int>& arr, int low, int high) {
    if (low < high) {
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}
Особенности алгоритма:

· Выбор опорного элемента
· Разделение на элементы меньше и больше опорного
· Рекурсивная обработка подмассивов

Эффективность: O(n log n) в среднем, O(n²) в худшем случае

 

Пирамидальная сортировка (Heap Sort)

Сортировка с использованием структуры данных "куча".

void heapify(vector<int>& arr, int n, int root) {
    int largest = root;
    int left = 2 * root + 1;
    int right = 2 * root + 2;
    
    if (left < n && arr[left] > arr[largest])
        largest = left;
    
    if (right < n && arr[right] > arr[largest])
        largest = right;
    
    if (largest != root) {
        swap(arr[root], arr[largest]);
        heapify(arr, n, largest);
    }
}

void heapSort(vector<int>& arr) {
    int n = arr.size();
    
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
    
    for (int i = n - 1; i > 0; i--) {
        swap(arr[0], arr[i]);
        heapify(arr, i, 0);
    }
}
Особенности алгоритма:

· Построение двоичной кучи
· Последовательное извлечение максимальных элементов
· Эффективное использование памяти

Эффективность: O(n log n) для всех случаев

 

Алгоритмы поиска

Линейный поиск

Последовательная проверка элементов массива.

def linear_search(sequence, target):
    for index, element in enumerate(sequence):
        if element == target:
            return index
    return -1
Особенности алгоритма:

· Поочередный перебор всех элементов
· Универсальность для любых данных
· Простота реализации

Эффективность: O(n) в худшем случае, O(1) в лучшем

 

Бинарный поиск

Поиск в упорядоченном массиве методом деления пополам.

def binary_search(ordered_list, item):
    left, right = 0, len(ordered_list) - 1
    
    while left <= right:
        middle = (left + right) // 2
        current = ordered_list[middle]
        
        if current == item:
            return middle
        elif current < item:
            left = middle + 1
        else:
            right = middle - 1
    
    return -1
Особенности алгоритма:

· Работает только с отсортированными данными
· Постоянное уменьшение области поиска
· Высокая эффективность для больших массивов

Эффективность: O(log n) в среднем и худшем случаях

 

Интерполяционный поиск

Усовершенствованный метод поиска для равномерно распределенных данных.

int interpolationSearch(const vector<int>& sortedData, int target) {
    int low = 0, high = sortedData.size() - 1;
    
    while (low <= high && target >= sortedData[low] && target <= sortedData[high]) {
        if (low == high) {
            return (sortedData[low] == target) ? low : -1;
        }
        
        int pos = low + ((target - sortedData[low]) * (high - low)) / 
                  (sortedData[high] - sortedData[low]);
        
        if (sortedData[pos] == target)
            return pos;
        
        if (sortedData[pos] < target)
            low = pos + 1;
        else
            high = pos - 1;
    }
    return -1;
}
Особенности алгоритма:

· Предсказание позиции на основе значений
· Особенно эффективен для равномерных данных
· Быстрее бинарного поиска в благоприятных условиях

Эффективность: O(log log n) в среднем, O(n) в худшем случае

 

Поиск Фибоначчи

Алгоритм поиска с использованием чисел Фибоначчи.
def fibonacci_search(ordered_array, x):
    fib2, fib1 = 0, 1
    fib = fib2 + fib1
    n = len(ordered_array)
    
    while fib < n:
        fib2, fib1 = fib1, fib
        fib = fib2 + fib1
    
    offset = -1
    while fib > 1:
        i = min(offset + fib2, n - 1)
        
        if ordered_array[i] < x:
            fib, fib1 = fib1, fib2
            fib2 = fib - fib1
            offset = i
        elif ordered_array[i] > x:
            fib, fib1 = fib2, fib1 - fib2
            fib2 = fib - fib1
        else:
            return i
    
    if fib1 and offset + 1 < n and ordered_array[offset + 1] == x:
        return offset + 1
    
    return -1
Особенности алгоритма:

· Использование последовательности Фибоначчи для деления
· Эффективен при дорогом сравнении элементов
· Минимизирует количество сравнений

Эффективность: O(log n) для всех случаев

 

Сравнительная характеристика алгоритмов:

Сортировка:

· Для небольших данных: вставками или выбором
· Для общих целей: быстрая сортировка или слиянием
· При ограниченной памяти: пирамидальная
· Для стабильности: слиянием

Поиск:

· Для неупорядоченных данных: линейный
· Для упорядоченных данных: бинарный
· Для равномерных данных: интерполяционный
· Для специфических задач: Фибоначчи
