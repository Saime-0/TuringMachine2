package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class MachineLogic {

    public static void main(String[] args) {
        System.out.println("Ведите ленту со значениями: \nПример: _01001_");
        Scanner scanner = new Scanner(System.in);
        char[] tape = scanner.nextLine().toCharArray();
        for (int i = 0; i < tape.length; i++) CellTape.append(tape[i]);

        for (int i = 0; i <= 1; i++) {
            System.out.printf("Введите значения для Q%d в форме <TRMG>: [Trigger] (0,1),  [Replace] (0,1),  [Move] ('<','>'), [reGister] (1,..,%d)\nПример: 01>1,10>1,__s2\n", i, i);
            String[] params = scanner.nextLine().split(",");
            RegisterTable.add(params);
        }
        int next_reg = 0;
        while (next_reg != -1) {
            next_reg = readRegister(next_reg);
        }
    }

    public static int readRegister(int id) {
        Register reg = RegisterTable.get(id);
        for (String options: reg.options) {
            char[] char_param = options.toCharArray();
            char trigger = char_param[0]; // если находит (0,1) UPD: ('0', '1', ' ')


            if (trigger == ScanningHead.cell.data) {
                char replace = char_param[1]; // заменяет на реплейс (0,1) UPD: ('0', '1', ' ')
                char move = char_param[2]; // передвигает сканер ('<', '>')
                int register = char_param[3] - '0'; // потом переходит в регистр (1, 2, 3, .., n)

                // normal features
                ScanningHead.cell.data = replace;
                String where = "undefined";
                if (move == '<') where = "left";
                if (move == '>') where = "right";
                System.out.printf(" Q%d -> trigger - %c, replaced by %c, move to %s, return(next) register Q%d\n", id, trigger, replace, where, register);
                if (move == '<') ScanningHead.toLeft();
                else if (move == '>') ScanningHead.toRight();
                return register;
            }
        }
        return id;
    }


}
