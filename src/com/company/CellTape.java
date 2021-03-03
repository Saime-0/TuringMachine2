package com.company;

public class CellTape {
    public static Cell head;

    public static void append(int data) {
        if (head == null) {
            head = new Cell(data);
            return;
        }
        Cell current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Cell(data);
        current.next.previous = current;
    }

    public static void prepend(int data) {
        Cell newHead = new Cell(data);
        if (head != null) {
            newHead.next = head;
            head.previous = newHead;
        }
        head = newHead;
    }

}
