# Лабораторная работа №8: Аннотации и рефлексия

## Задание
Создать аннотацию @DataProcessor, класс DataManager для регистрации обработчиков и многопоточной обработки данных, несколько классов-обработчиков.

## Классы

### DataProcessor.java
Аннотация с параметром description.  
RetentionPolicy.RUNTIME – доступна во время выполнения.  
ElementType.METHOD – только для методов.

### Обработчики
- FilterProcessor – оставляет слова длиннее 3 букв
- UpperCaseProcessor – переводит строку в верхний регистр
- ReverseProcessor – переворачивает строку

### DataManager.java
- registerDataProcessor() – добавляет обработчик в список
- loadData() – читает файл через Files.readAllBytes()
- processData() – через рефлексию находит методы с аннотацией и запускает их в ExecutorService (многопоточно)
- saveData() – сохраняет результат в файл

Запуск: java Main (предварительно создать `input.txt`)
