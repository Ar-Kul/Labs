import java.util.concurrent.*;

public class MatrixMaxThreads {
    private static int globalMax = Integer.MIN_VALUE;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        int[][] matrix = {
            {3, 8, 1, 9, 4},
            {5, 12, 7, 6, 11},
            {14, 2, 10, 13, 5},
            {8, 9, 4, 15, 7},
            {6, 3, 5, 8, 10}
        };

        int rows = matrix.length;
        ExecutorService executor = Executors.newFixedThreadPool(rows);
        Future<Integer>[] futures = new Future[rows];

        for (int i = 0; i < rows; i++) {
            final int rowIndex = i;
            futures[i] = executor.submit(() -> {
                int maxInRow = matrix[rowIndex][0];
                for (int j = 1; j < matrix[rowIndex].length; j++) {
                    if (matrix[rowIndex][j] > maxInRow) {
                        maxInRow = matrix[rowIndex][j];
                    }
                }
                System.out.println("Строка " + rowIndex + " максимум: " + maxInRow);
                return maxInRow;
            });
        }

        try {
            for (int i = 0; i < rows; i++) {
                int rowMax = futures[i].get(); 
                synchronized (lock) {
                    if (rowMax > globalMax) {
                        globalMax = rowMax;
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ошибка при получении результата: " + e.getMessage());
        }

        executor.shutdown();
        System.out.println("\nНаибольший элемент матрицы: " + globalMax);
    }
}
