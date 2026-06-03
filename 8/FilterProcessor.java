public class FilterProcessor {
    @DataProcessor(description = "Фильтрация: оставляем слова длиннее 3 букв")
    public String process(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 3) {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }
}
