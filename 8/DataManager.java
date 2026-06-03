import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private String data = "";
    
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }
    
    public void loadData(String source) throws IOException {
        data = new String(Files.readAllBytes(Paths.get(source)));
        System.out.println("Загружено из файла " + source);
        System.out.println("Содержимое: " + data);
    }
    
    public void processData() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(processors.size());
        
        for (Object processor : processors) {
        
            java.lang.reflect.Method[] methods = processor.getClass().getDeclaredMethods();
            for (java.lang.reflect.Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    DataProcessor ann = method.getAnnotation(DataProcessor.class);
                    System.out.println("\nЗапуск: " + ann.description());
                    
                    executor.submit(() -> {
                        try {
                            Object result = method.invoke(processor, data);
                            System.out.println("Результат: " + result);
                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    });
                }
            }
        }
        
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
    
    public void saveData(String destination, String result) throws IOException {
        Files.write(Paths.get(destination), result.getBytes());
        System.out.println("Сохранено в файл: " + destination);
    }
}
