package ap_f2025.threads.opgave_3;

import java.util.Random;

/**
 * Consumer
 */
public class Consumer implements Runnable {
    SBuffer Q;

    public Consumer(SBuffer sb) {
        Q = sb;
    }

    @Override
    public void run() {
        Random rng = new Random();
        while (true) {
            try {
                String str = Q.pop();
                System.out.printf("[%s]: popped string \"%s\"%n", Thread.currentThread().getName(), str);
                Thread.sleep(rng.nextInt(500, 2500));
            } catch (Exception e) {
                return;
            }
        }
    }

}
