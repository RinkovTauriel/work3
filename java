import java.util.Arrays;

public class SortingAlgorithms {
    
    // 1. Сортировка выбором
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    
    // 2. Сортировка пузырьком
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // 3. Сортировка вставками
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    // 4. Сортировка слиянием
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            
            mergeSort(left);
            mergeSort(right);
            
            merge(arr, left, right);
        }
    }
    
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
    
    // 5. Сортировка Шелла
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
    
    // 6. Быстрая сортировка
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    // 7. Пирамидальная сортировка
    public static void heapSort(int[] arr) {
int n = arr.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, n, largest);
        }
    }
    
    // Тестирование
    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30};
        
        System.out.println("JAVA АЛГОРИТМЫ СОРТИРОВКИ");
        System.out.println("Исходный массив: " + Arrays.toString(original));
        System.out.println();
        
        // Тестирование всех алгоритмов сортировки
        testAlgorithm("Сортировка выбором", original, SortingAlgorithms::selectionSort);
        testAlgorithm("Сортировка пузырьком", original, SortingAlgorithms::bubbleSort);
        testAlgorithm("Сортировка вставками", original, SortingAlgorithms::insertionSort);
        testAlgorithm("Сортировка слиянием", original, arr -> mergeSort(arr));
        testAlgorithm("Сортировка Шелла", original, SortingAlgorithms::shellSort);
        testAlgorithm("Быстрая сортировка", original, arr -> quickSort(arr, 0, arr.length - 1));
        testAlgorithm("Пирамидальная сортировка", original, SortingAlgorithms::heapSort);
    }
    
    private static void testAlgorithm(String name, int[] original, java.util.function.Consumer<int[]> algorithm) {
        int[] arr = Arrays.copyOf(original, original.length);
        algorithm.accept(arr);
        System.out.println(name + ": " + Arrays.toString(arr));
    }
}


Вывод Java программы:

JAVA АЛГОРИТМЫ СОРТИРОВКИ
Исходный массив: [64, 34, 25, 12, 22, 11, 90, 5, 77, 30]

Сортировка выбором: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]
Сортировка пузырьком: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]
Сортировка вставками: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]
Сортировка слиянием: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]
Сортировка Шелла: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]
Быстрая сортировка: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]
Пирамидальная сортировка: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]


java/SearchAlgorithms.java

java
import java.util.Arrays;

public class SearchAlgorithms {
    
    // 8. Последовательный поиск
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // 9. Бинарный поиск
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    // 10. Интерполирующий поиск
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high && target >= arr[low] && target <= arr[high]) {
if (low == high) {
                if (arr[low] == target) return low;
                return -1;
            }
            
            int pos = low + (((high - low) / (arr[high] - arr[low])) * (target - arr[low]));
            
            if (arr[pos] == target) {
                return pos;
            } else if (arr[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1;
    }
    
    // 11. Поиск Фибоначчи
    public static int fibonacciSearch(int[] arr, int target) {
        int fib2 = 0;
        int fib1 = 1;
        int fib = fib2 + fib1;
        int n = arr.length;
        
        while (fib < n) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib2 + fib1;
        }
        
        int offset = -1;
        
        while (fib > 1) {
            int i = Math.min(offset + fib2, n - 1);
            
            if (arr[i] < target) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } else if (arr[i] > target) {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            } else {
                return i;
            }
        }
        
        if (fib1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            return offset + 1;
        }
        
        return -1;
    }
    
    // Тестирование
    public static void main(String[] args) {
        int[] sortedArray = {5, 11, 12, 22, 25, 30, 34, 64, 77, 90};
        int target = 25;
        
        System.out.println("JAVA АЛГОРИТМЫ ПОИСКА");
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));
        System.out.println("Искомый элемент: " + target);
        System.out.println();
        
        System.out.println("Последовательный поиск: индекс " + linearSearch(sortedArray, target));
        System.out.println("Бинарный поиск: индекс " + binarySearch(sortedArray, target));
        System.out.println("Интерполирующий поиск: индекс " + interpolationSearch(sortedArray, target));
        System.out.println("Поиск Фибоначчи: индекс " + fibonacciSearch(sortedArray, target));
    }
}


Вывод Java программы:

JAVA АЛГОРИТМЫ ПОИСКА
Отсортированный массив: [5, 11, 12, 22, 25, 30, 34, 64, 77, 90]
Искомый элемент: 25

Последовательный поиск: индекс 4
Бинарный поиск: индекс 4
Интерполирующий поиск: индекс 4
Поиск Фибоначчи: индекс 4
