package com.company;

public class ScanningHead {
    public static Cell cell = CellTape.head;

    public static void toLeft() {
        cell = cell.previous;
    }

    public static void toRight() {
        cell = cell.next;
    }
}
