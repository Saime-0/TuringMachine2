package com.company;

public class CellTape {
    public static Cell head;
    private static int size = 0;

    public static void append() {
        CellTape.append('_');
    }

    public static void append(char data) {
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
        size = size + 1;
    }

    public static void prepend() {
        CellTape.prepend('_');
    }

    public static void prepend(char data) {
        Cell newHead = new Cell(data);
        if (head != null) {
            newHead.next = head;
            head.previous = newHead;
        }
        head = newHead;
        size = size + 1;
    }

    public static int get(int id) {
        Cell current = head;
        for (int i = 0; i < id; i++) {
            current = current.next;
        }
        return current.data;
    }

    public static void set(int id, char data) {
        Cell current = head;
        for (int i = 0; i < id; i++) {
            current = current.next;
        }
        current.data = data;
    }

    public static int size() {
        return size;
    }

    public static String returnString() {
        Object o;
        StringBuilder str = new StringBuilder();
        if (head != null) str.append(head.data);
        Cell current = head;
        while (current.next != null) {
            current = current.next;
            str.append(current.data);
        }

        return str.toString();
    }
}
