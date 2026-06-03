public class ReverseProcessor {
    @DataProcessor(description = "Переворот строки")
    public String process(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
