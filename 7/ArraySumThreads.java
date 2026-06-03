public class ArraySumThreads {
    private static int sum1 = 0;
    private static int sum2 = 0;

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < array.length / 2; i++) {
                sum1 += array[i];
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = array.length / 2; i < array.length; i++) {
                sum2 += array[i];
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int totalSum = sum1 + sum2;
        System.out.println("Сумма: " + totalSum);
    }
}
