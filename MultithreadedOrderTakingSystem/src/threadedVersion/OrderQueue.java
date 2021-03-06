package threadedVersion;

import java.util.LinkedList;

public class OrderQueue {
    private LinkedList<Order> orderQueue = new LinkedList<>();

    public synchronized void pushOrder(Order order) {
        orderQueue.addLast(order);
        notifyAll();
    }

    public synchronized Order pullOrder() {
        while (orderQueue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return orderQueue.removeFirst();
    }
}
