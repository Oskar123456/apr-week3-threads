package ap_f2025.threads.opgave_3;

import java.util.Random;

/**
 * Producer
 */
public class Producer implements Runnable {
    SBuffer Q;

    public Producer(SBuffer sb) {
        Q = sb;
    }

    @Override
    public void run() {
        Random rng = new Random();
        while (true) {
            try {
                Thread.sleep(rng.nextInt(500, 2500));
            } catch (Exception e) {
                return;
            }
        }
    }
}
