#include <iostream>
#include <sstream>  
using namespace std;

int stringToInt(const string& str) {
    int num = 0;
    for (char ch : str) {
        num = num * 10 + (ch - '0'); 
    }
    return num;
}

int calculate(int a, int b, char op) {
    if (op == '+') return a + b;
    if (op == '-') return a - b;
    if (op == '*') return a * b;
    if (op == '/') return a / b;
    return 0;  
}

int main() {
    string input; 

    while (true) {
        cout << "Введите выражение: ";
        cin >> input;  

        int result = 0;
        char currentOp = '+';  
        string currentNumber = "";  

       
        for (char ch : input) {
            if (ch >= '0' && ch <= '9') {
               
                currentNumber += ch;
            } else if (ch == ' ') {
               
                continue;
            } else {
            
                if (!currentNumber.empty()) {
                    int num = stringToInt(currentNumber);  
                    result = calculate(result, num, currentOp);  

                    currentNumber = "";  

                currentOp = ch;  
        }

        
        if (!currentNumber.empty()) {
            int num = stringToInt(currentNumber);
            result = calculate(result, num, currentOp);
        }

        cout << "Результат: " << result << endl; 
    }

    return 0;
}
