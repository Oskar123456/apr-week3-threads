package ap_f2025.threads.opgave_3;

/**
 * SBuffer
 */
public class SBuffer {
    String[] Q;
    int head, tail, cap;

    public SBuffer() {
        cap = 4;
        Q = new String[cap];
    }

    public int getSize() {
        return (head - tail + cap) % cap;
    }

    public void push(String str) {
        if (getSize() + 1 >= cap) {
            String[] old = Q;
            int sz = getSize();
            Q = new String[cap * 2];
            for (int i = 0; i < sz; i++) {
                Q[i] = old[tail];
                tail = (tail + 1) % cap;
            }
            cap *= 2;
            tail = 0;
            head = sz;
        }
        Q[head] = str;
        head = (head + 1) % cap;
    }

    public String pop() {
        if (getSize() <= 0) {
            return null;
        }
        String str = Q[tail];
        Q[tail] = null;
        tail = (tail + 1) % cap;
        return str;
    }

    public void print() {
        System.out.printf("SBuffer(size: %d/%d)%n", getSize(), cap);
        for (int i = 0; i < cap; i++) {
            if (i == head && i == tail) {
                System.out.printf("\t[H&&T] ");
            } else if (i == head) {
                System.out.printf("\t[HEAD] ");
            } else if (i == tail) {
                System.out.printf("\t[TAIL] ");
            } else {
                System.out.printf("\t       ");
            }
            System.out.printf("[%d] %s%n", i, Q[i] != null ? Q[i] : "null");
        }
    }
}
