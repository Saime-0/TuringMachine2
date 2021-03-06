package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class MachineLogic {

    public static void main(String[] args) {
        System.out.println("Ведите ленту со значениями: \nПример: 01001_");
        Scanner scanner = new Scanner(System.in);
        char[] tape = scanner.nextLine().toCharArray();
        for (int i = 0; i < tape.length; i++) CellTape.append(tape[i]);


        System.out.println("Введите значения для регистров в форме TRMG,TRMG,TRMG;TRMG,TRMG,TRMG: [Trigger] (0,1),  [Replace] (0,1),  [Move] ('<','>'), [reGister] (1, 2, 3, ..., n)\nПример: 01>0,10>0,__s1;00<1,11<1,__<1;");
        for (String reg : scanner.nextLine().split(";")) {
            RegisterTable.add(reg.split(","));
        }

        int next_reg = 0;
        while (next_reg != -1) {
            next_reg = readRegister(next_reg);
        }
    }

    public static int readRegister(int id) {
        Register reg = RegisterTable.get(id);
        String last_out = CellTape.returnString();
        for (String options : reg.options) {
            char[] char_param = options.toCharArray();
            char trigger = char_param[0]; // если находит (0,1) UPD: ('0', '1', ' ')


            if (trigger == ScanningHead.cell.data) {
                char replace = char_param[1]; // заменяет на реплейс (0,1) UPD: ('0', '1', ' ')
                char move = char_param[2]; // передвигает сканер ('<', '>')
                int register = char_param[3] - '0'; // потом переходит в регистр (1, 2, 3, .., n)

                // normal features
                ScanningHead.cell.data = replace;
                String where = "to stay";
//                if (move == '<') where = "to left";
//                else if (move == '>') where = " to right";
//                System.out.printf("Q%d -> trigger - %c, replaced by %c, %s, next register Q%d, tape == %s\n", id, trigger, replace, where, register, CellTape.returnString());
                if (!last_out.equals(CellTape.returnString())) {
                    System.out.printf("Changed: %s\n", CellTape.returnString());
                    last_out = CellTape.returnString();
                }

                if (move == '<') ScanningHead.toLeft();
                else if (move == '>') ScanningHead.toRight();
                return register;
            }
        }
        return id;
    }


}