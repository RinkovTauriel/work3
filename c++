#include <iostream>
#include <string>
using namespace std;

int main() {
    string str_1 = "AaBbCcDd";
    string uppercase_str = "";
    string lowercase_str = "";
    
    // Получаем заглавные буквы (четные индексы: 0, 2, 4, 6)
    for (int i = 0; i < str_1.length(); i += 2) {
        uppercase_str += str_1[i];
    }
    
    // Получаем строчные буквы (нечетные индексы: 1, 3, 5, 7)
    for (int i = 1; i < str_1.length(); i += 2) {
        lowercase_str += str_1[i];
    }
    
    // Выводим результаты
    cout << "Заглавные буквы: " << uppercase_str << endl;
    cout << "Строчные буквы: " << lowercase_str << endl;
    
    return 0;
}

#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    vector<string> li = {"a", "1", "b", "2", "c", "3"};
    vector<string> li_1; // для букв
    vector<string> li_2; // для чисел
    
    // Разделяем список на буквы и числа
    for (int i = 0; i < li.size(); i++) {
        if (i % 2 == 0) {
            li_1.push_back(li[i]); // четные индексы - буквы
        } else {
            li_2.push_back(li[i]); // нечетные индексы - числа
        }
    }
    
    // Очищаем исходный список (аналог del li в Python)
    li.clear();
    
    // Выводим полученные списки
    cout << "Буквы: ";
    for (const auto& item : li_1) {
        cout << item << " ";
    }
    cout << endl << endl;
    
    cout << "Числа: ";
    for (const auto& item : li_2) {
        cout << item << " ";
    }
    cout << endl;
    
    return 0;
}

