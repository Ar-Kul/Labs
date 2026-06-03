public class Primes {
    public static void main(String args[]) {
        System.out.println("Простые числа от 2 до 100");
        System.out.print(2 + " ");
        for (int i = 3; i <= 100; i += 2) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static boolean isPrime(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
