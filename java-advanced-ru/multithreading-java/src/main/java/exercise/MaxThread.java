package exercise;

// BEGIN
public class MaxThread extends Thread {
    private final int numbers[];
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
        this.max = numbers.length > 0 ? numbers[0] : Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " started");

        for(var nubmer : numbers) {
            if(nubmer > max) {
                max = nubmer;
            }
        }
        System.out.println("INFO: Thread " + Thread.currentThread().getName() + " finished");
    }

    public int getMax() {
        return max;
    }
}
// END
