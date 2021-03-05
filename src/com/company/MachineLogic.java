package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class MachineLogic {

    public static void main(String[] args) {
        System.out.println("Ведите ленту со значениями: ");
        Scanner scanner = new Scanner(System.in);
        char[] tape = scanner.nextLine().toCharArray();

        for (int i = 1; i <= 3; i++) {
            System.out.printf("Введите значения для Q%d: [trigger] (0,1),  [replace] (0,1),  [move] (<,>), [register] (1,..,%d)\n", i, i);
            char[] register = scanner.nextLine().toCharArray();
            RegisterTable.add(register[0], register[1], register[2], (int) register[3]);
        }
        int next_reg = 1;
        while (next_reg != -1) {
            next_reg = readRegister(next_reg);
        }
    }

    public static int readRegister(int id) {
        Register reg = RegisterTable.get(id);

        if (reg.trigger == ScanningHead.cell.data) ScanningHead.cell.data = reg.replace;

        if (reg.move == '<') ScanningHead.toLeft();
        else if (reg.move == '>') ScanningHead.toRight();
        System.out.printf(" Q%d -> trigger = %c, replace = %c, move = %c, register = %d\n", id, reg.trigger, reg.replace, reg.move, reg.register);
        return reg.register;
    }


}
