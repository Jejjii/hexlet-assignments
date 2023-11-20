package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String,Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Map.of("max", maxThread.getMax(),"min", minThread.getMin());
    }

    public static void main(String[] args) {
        int[] numbers = {10, -4, 67, 100, -100, 8};
        System.out.println(App.getMinMax(numbers)); // => {min=-100, max=100}
    }

    // END
}
