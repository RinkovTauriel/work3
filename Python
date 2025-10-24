cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void selectionSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[i], arr[minIndex]);
    }
}

void bubbleSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
}

void insertionSort(vector<int>& arr) {
    int n = arr.size();
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

void merge(vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    vector<int> L(n1), R(n2);
    
    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];
        
    int i = 0, j = 0, k = left;
    
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

void shellSort(vector<int>& arr) {
    int n = arr.size();
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

int partition(vector<int>& arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    
    for (int j = low; j <= high - 1; j++) {
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
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

void heapify(vector<int>& arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    
    if (left < n && arr[left] > arr[largest])
        largest = left;
        
    if (right < n && arr[right] > arr[largest])
        largest = right;
        
    if (largest != i) {
        swap(arr[i], arr[largest]);
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

void printArray(const vector<int>& arr) {
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;
}

int main() {
    vector<int> original = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30};
    
    cout << "C++ АЛГОРИТМЫ СОРТИРОВКИ" << endl;
    cout << "Исходный массив: ";
    printArray(original);
    cout << endl;
    
    vector<int> arr;
    
    arr = original;
    selectionSort(arr);
    cout << "Сортировка выбором: ";
    printArray(arr);
    
    arr = original;
    bubbleSort(arr);
    cout << "Сортировка пузырьком: ";
    printArray(arr);
    
    arr = original;
    insertionSort(arr);
    cout << "Сортировка вставками: ";
    printArray(arr);
    
    arr = original;
    mergeSort(arr, 0, arr.size() - 1);
    cout << "Сортировка слиянием: ";
    printArray(arr);
    
    arr = original;
    shellSort(arr);
    cout << "Сортировка Шелла: ";
    printArray(arr);
    
    arr = original;
    quickSort(arr, 0, arr.size() - 1);
    cout << "Быстрая сортировка: ";
    printArray(arr);
    
    arr = original;
    heapSort(arr);
    cout << "Пирамидальная сортировка: ";
    printArray(arr);
    
    return 0;
}


Вывод C++ программы:

C++ АЛГОРИТМЫ СОРТИРОВКИ
Исходный массив: 64 34 25 12 22 11 90 5 77 30 

Сортировка выбором: 5 11 12 22 25 30 34 64 77 90 
Сортировка пузырьком: 5 11 12 22 25 30 34 64 77 90 
Сортировка вставками: 5 11 12 22 25 30 34 64 77 90 
Сортировка слиянием: 5 11 12 22 25 30 34 64 77 90 
Сортировка Шелла: 5 11 12 22 25 30 34 64 77 90 
Быстрая сортировка: 5 11 12 22 25 30 34 64 77 90 
Пирамидальная сортировка: 5 11 12 22 25 30 34 64 77 90 


cpp/search_algorithms.cpp

cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int linearSearch(const vector<int>& arr, int target) {
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

int binarySearch(const vector<int>& arr, int target) {
    int left = 0;
    int right = arr.size() - 1;
    
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

int interpolationSearch(const vector<int>& arr, int target) {
    int low = 0;
    int high = arr.size() - 1;
    
    while (low <= high && target >= arr[low] && target <= arr[high]) {
        if (low == high) {
            if (arr[low] == target) return low;
            return -1;
        }
        
        int pos = low + (((double)(high - low) / 
                         (arr[high] - arr[low])) * (target - arr[low]));
                         
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
int fibonacciSearch(const vector<int>& arr, int target) {
    int fib2 = 0;
    int fib1 = 1;
    int fib = fib2 + fib1;
    int n = arr.size();
    
    while (fib < n) {
        fib2 = fib1;
        fib1 = fib;
        fib = fib2 + fib1;
    }
    
    int offset = -1;
    
    while (fib > 1) {
        int i = min(offset + fib2, n - 1);
        
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
    
    if (fib1 && offset + 1 < n && arr[offset + 1] == target) {
        return offset + 1;
    }
    
    return -1;
}

int main() {
    vector<int> sortedArray = {5, 11, 12, 22, 25, 30, 34, 64, 77, 90};
    int target = 25;
    
    cout << "C++ АЛГОРИТМЫ ПОИСКА" << endl;
    cout << "Отсортированный массив: ";
    for (int num : sortedArray) {
        cout << num << " ";
    }
    cout << endl;
    cout << "Искомый элемент: " << target << endl;
    cout << endl;
    
    cout << "Последовательный поиск: индекс " << linearSearch(sortedArray, target) << endl;
    cout << "Бинарный поиск: индекс " << binarySearch(sortedArray, target) << endl;
    cout << "Интерполирующий поиск: индекс " << interpolationSearch(sortedArray, target) << endl;
    cout << "Поиск Фибоначчи: индекс " << fibonacciSearch(sortedArray, target) << endl;
    
    return 0;
}


Вывод C++ программы:

C++ АЛГОРИТМЫ ПОИСКА
Отсортированный массив: 5 11 12 22 25 30 34 64 77 90 
Искомый элемент: 25

Последовательный поиск: индекс 4
Бинарный поиск: индекс 4
Интерполирующий поиск: индекс 4
Поиск Фибоначчи: индекс 4
