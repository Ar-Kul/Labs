public class UpperCaseProcessor {
    @DataProcessor(description = "Преобразование в верхний регистр")
    public String process(String input) {
        return input.toUpperCase();
    }
}
