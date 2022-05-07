/**
 *
 * @author josephcucco
 * JoeyCucco
 * CIS2353
 * Winter2022
 * Project2
 */
package proj2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.nio.charset.StandardCharsets;

public class ScoreList<T> {

    //Implement a Node
    private static class Node<T> {

        private T element;
        private Node<T> next;
        String name;
        int score;

        public Node(T e, Node<T> n, int score) {
            element = e;
            next = n;
            this.name = name;
            this.score = score;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> n) {
            next = n;
        }
    }

    // List Implementation
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public ScoreList() {
    }

    public int size() {
        return size;
    }

    public T first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public T last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

//   public void add(T e, int score) {
//        head = new Node(e, head, score);
//        Node<T> newNode  = new Node<T>(e, head, score);
//        Node<T> current = head;
//        Node<T> previous = null;
//        
//        if (head == null) {
//           head = newNode;
//            System.out.println(head);
//           return;
//        }
//        while (head.getNext() != null) {
//            if (current.score > newNode.score) {
//                previous = current.getNext();
//                System.out.println(previous.element + " " + previous.score);
//                current = previous;
//            }
//            else {
//                if (previous == null) {
//                    head = newNode;
//                    head.next = current;
//                }
//                else {
//                    previous.next = newNode;
//                    newNode.next = current;
//                }
//            }
//        }
//    }
    public void add(T e, int score) {
        head = new Node<>(e, head, score);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void sortList() {

        // Node current will point to head
        Node current = head, index = null;

        int temp;       
        String tempName;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.score < index.score) {
                        temp = current.score;
                        tempName = current.name;
                        current.score = index.score;
                        current.name = index.name;
                        index.score = temp;
                        index.name = tempName;
                        
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public ScoreList readFromFile() throws IOException {
        String fileName = "scores.txt";
        ScoreList sLTemp = new ScoreList(); //Instance of ScoreList in Demo Class.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));) {
            String line;
//            System.out.println(br.readLine());
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(" ", 2);
                int score = parseInt(arr[1]);
                sLTemp.add(arr[0],score);
            }
        }
        return sLTemp;
    }

    public T remove(String e) {
        Node<T> current = head;
        Node<T> previous = head;
        int position = 0;
        while (current != null && current.getElement() != e) {
            previous = current;
            current = current.getNext();
            position++;
        }
        if (current == null) {
            return null;
        } else {
            if (head == current) {
                head = current.getNext();
            } else if (tail == current) {
                tail = previous;
                tail.setNext(null);
            } else {
                previous.setNext(current.getNext());
            }
            size--;
            return current.getElement();
        }
    }

    public void listItems() {
        Node<T> current = head;
        Node<T> previous = head;
    System.out.println(head.element + " " + head.score);

        while (current.getNext() != null) {   
            previous = current.getNext();
            System.out.println(previous.element + " " + previous.score);
            current = previous;
        }
    }

    public ScoreList copy(ScoreList list) {
        Node<T> current = head;
        Node<T> previous = head;
        int position = 0;
        while (current != null && current.getElement() != list) {
            list.add(current.name, current.score);
            previous = current;
            current = current.getNext();
        }
        return list;
    }
}
