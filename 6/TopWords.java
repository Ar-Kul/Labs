import java.io.*;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "text.txt";
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");
                if (word.length() > 0) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        System.out.println("Топ-10 самых частых слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.println((i+1) + ". " + list.get(i).getKey() + " – " + list.get(i).getValue() + " раз");
        }
    }
}
