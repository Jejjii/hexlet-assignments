package exercise;

// BEGIN
public class MinThread extends Thread {
    private final int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
        this.min = numbers.length > 0 ? numbers[0] : Integer.MAX_VALUE;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " started");

        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMin() {
        return min;
    }
}
// END
