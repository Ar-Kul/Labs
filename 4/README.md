# Лабораторная работа №4: Обработка исключений (Вариант 1)

## Задание 1: ArrayAverage.java
Вычисление среднего арифметического элементов массива. Пользователь вводит размер и элементы через пробел.
- NumberFormatException – если введено не число
- ArrayIndexOutOfBoundsException – если введено меньше чисел, чем нужно

## Задание 2: FileCopy.java
Копирование файла source.txt в destination.txt. Чтение и запись по одному символу.
- FileNotFoundException – если исходный файл не найден
- IOException – ошибки ввода-вывода
- Потоки закрываются в finally с проверкой на null

## Задание 3: DivisionProgram.java + CustomDivisionException.java
Деление двух чисел. При делении на ноль выбрасывается собственное исключение CustomDivisionException.
- Создан класс исключения, наследуемый от Exception
- Метод log() записывает ошибки в exceptions_log.txt (режим дозаписи)
- Обрабатывается также NumberFormatException при вводе не числа

Запуск: java ArrayAverage, java FileCopy, java DivisionProgram
