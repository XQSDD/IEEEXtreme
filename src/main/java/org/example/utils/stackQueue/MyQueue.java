package org.example.utils.stackQueue;

import java.util.Stack;

/**
 * @author pc
 * @description 用栈实现队列
 * @create 2023/10/27 21:12
 */
public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {


    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (! stack2.isEmpty()) {
            int val = stack2.pop();
            stack1.push(val);
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (! stack1.isEmpty()) {
            int val = stack1.pop();
            stack2.push(val);
        }
        if (stack2.isEmpty()) return -1;
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (! stack1.isEmpty()) {
            int val = stack1.pop();
            stack2.push(val);
        }
        if (stack2.isEmpty()) return -1;
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
