package com.company;

public class ScanningHead {
    public static Cell cell = CellTape.head;

    public static void toLeft() {
        if (cell.previous == null) CellTape.prepend(); // TODO: сделал я бесконечную ленту, а теперь надо чтобы во входных данных я мог в лбое место вставлять числ
        cell = cell.previous;
    }

    public static void toRight() {
        if (cell.next == null) CellTape.append();
        cell = cell.next;
    }
}
