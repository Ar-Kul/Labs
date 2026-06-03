public class Main {
    public static void main(String[] args) throws Exception {
        DataManager manager = new DataManager();
        
        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new UpperCaseProcessor());
        manager.registerDataProcessor(new ReverseProcessor());
        
        manager.loadData("input.txt");

        manager.processData();
        

        manager.saveData("output.txt", "Обработка завершена");
    }
}
