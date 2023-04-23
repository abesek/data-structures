package ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Stack<Item> implements Iterable<Item> {
    private Node head;
    private int size;

    private class Node {
        private Item data;
        private Node next;
    }

    public Stack() {
        size = 0;
        head = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Item data) {
        if (isEmpty()) { // if block not needed
            head = new Node();
            head.data = data;
        } else {
            Node oldHead = head;
            head = new Node();
            head.data = data;
            head.next = oldHead;
        }
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return head.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) {
            sb.append(item + " ");
        }
        return sb.toString();
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node curr = head;

        public boolean hasNext() {
            return curr != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item data = curr.data;
            curr = curr.next;
            return data;
        }
    }

    // public static void main(String[] args) {
    //     Stack<String> stack = new Stack<String>();
    //     try {
    //         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             if (!line.equals("-"))
    //                 stack.push(line);
    //             else if (!stack.isEmpty())
    //                 System.out.print(stack.pop() + " ");
    //         }
    //         reader.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     System.out.println(stack);
    // }
}