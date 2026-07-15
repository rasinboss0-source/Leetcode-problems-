import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);                    // new element-ah add pannu
        int size = queue.size();
        // munnadi irukura elements-ah eduthu, back-ku thirumba vachu
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();              // front element-ah remove pannu
    }
    
    public int top() {
        return queue.peek();              // front element-ah paaru (remove pannama)
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
