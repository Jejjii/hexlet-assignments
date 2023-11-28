package exercise;

import java.util.Random;

// BEGIN
// ListThread.java
public class ListThread implements Runnable {
    private SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1); // Sleep for 1 millisecond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            safetyList.add((int) (Math.random() * 1000));
        }
    }
}

// END
