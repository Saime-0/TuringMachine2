package com.company;

public class ScanningHead {
    public static Cell cell = CellTape.head;

    public static void toLeft() {
        if (cell.previous == null) {
            System.out.println("Конец программы - сканер вернулся в начальное положение");
            System.exit(0);
        }
        cell = cell.previous;
    }

    public static void toRight() {
        cell = cell.next;
    }
}
