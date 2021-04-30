package study.chapter01.practice;

import java.util.*;

public class QueueTest {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // add와 offer는 동일하게 추가하는 작업을 하지만 오류가 발생하면 add는 예외를 발생시키고 offer는 false를 반환한다.
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.offer(5);

        System.out.println("queue.size(): " + queue.size());
        Integer returnValue = queue.poll(); // 첫번째 값을 반환하고 큐에서 제거, 비어있다면 null
        System.out.println("poll() value: " + returnValue + " after queue.size(): " + queue.size());
        returnValue = queue.remove(); // 첫번째 값을 반환하고 큐에서 제거, 비어있다면 예외발생.
        System.out.println("remove() value: " + returnValue + " after queue.size(): " + queue.size());
        returnValue = queue.element(); // 첫번째 값을 반환하고 비어있다면 예외발생.(큐에서 삭제 안함)
        System.out.println("element() value: " + returnValue + " after queue.size(): " + queue.size());
        returnValue = queue.peek(); // 첫번째 값을 반환하고 비어있다면 null.(큐에서 삭제 안함)
        System.out.println("peek() value: " + returnValue + " after queue.size(): " + queue.size());
        queue.clear();
        System.out.println("clear() value: after queue.size(): " + queue.size());


        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(4);

        while(!priorityQueue.isEmpty()) {
            System.out.println("priorityQueue.poll(): " + priorityQueue.poll());
        }

        Queue<Integer> priorityReverseQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityReverseQueue.offer(3);
        priorityReverseQueue.offer(1);
        priorityReverseQueue.offer(5);
        priorityReverseQueue.offer(2);
        priorityReverseQueue.offer(4);

        while(!priorityReverseQueue.isEmpty()) {
            System.out.println("priorityReverseQueue.poll(): " + priorityReverseQueue.poll());
        }



    }

}
