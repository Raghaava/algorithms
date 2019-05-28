package org.interview.preperation.queue;

import java.util.Stack;

public class QueueUsingTwoStacks<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    //O(1)
    public void enqueue(T element) {
        if (element != null) {
            stack1.push(element);
        }
    }

    //O(n)
    public T dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return null;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public static void main(String args[]) {
        QueueUsingTwoStacks<String> queue = new QueueUsingTwoStacks<>();

        System.out.println(queue.size());

        queue.enqueue("Raghava");
        queue.enqueue("Hari");
        queue.enqueue("RK");

        System.out.println(queue.size());

        System.out.println(queue.dequeue());

        System.out.println(queue.size());

        System.out.println(queue.dequeue());

        System.out.println(queue.size());

        System.out.println(queue.isEmpty());
    }
}
