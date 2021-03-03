package com.company;

public class MachineLogic {

    public static void main(String[] args) {

    }

    public static int readRegister(int id) {
        Register reg = RegisterTable.get(id);

        if (reg.trigger == ScanningHead.cell.data) ScanningHead.cell.data = reg.replace;

        if (reg.move == '<') ScanningHead.toLeft();
        else if (reg.move == '>') ScanningHead.toRight();

        return reg.register;
    }
}
