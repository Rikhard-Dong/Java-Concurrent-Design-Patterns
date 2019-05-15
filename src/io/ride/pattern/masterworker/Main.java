package io.ride.pattern.masterworker;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 11:18
 */
public class Main {

    public static void main(String[] args) {
        Master master = new Master(10);

        for (int i = 0; i < 10; i++) {
            Task task = new Task(i, "task-" + i);
            master.submit(task);
        }

        long start = System.currentTimeMillis();
        master.start();

        while (true) {
            if (master.isComplete()) {
                System.out.println("sum result is " + master.getSumResult() + " . cost time : " + (System.currentTimeMillis() - start));
                break;
            }
        }
    }
}
