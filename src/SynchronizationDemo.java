class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
        }
        System.out.println();
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(100);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        Table t = new Table();
        MyThread1 t1 = new MyThread1(t);
        MyThread2 t2 = new MyThread2(t);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
        }
        t2.start();
    }
}
