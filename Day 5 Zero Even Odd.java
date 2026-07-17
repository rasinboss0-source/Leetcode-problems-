import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSem = new Semaphore(1); // starts unlocked (zero goes first)
    private Semaphore evenSem = new Semaphore(0);
    private Semaphore oddSem = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSem.acquire();       // wait for its turn
            printNumber.accept(0);
            if (i % 2 == 0) {
                evenSem.release();   // let even thread go
            } else {
                oddSem.release();    // let odd thread go
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();       // wait until zero() signals
            printNumber.accept(i);
            zeroSem.release();       // let zero go again
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();        // wait until zero() signals
            printNumber.accept(i);
            zeroSem.release();       // let zero go again
        }
    }
}
