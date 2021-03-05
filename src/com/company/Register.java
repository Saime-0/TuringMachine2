package com.company;

public class Register {
    // TODO: сделать мессив из всех параметов
    char trigger; // если находит то (0,1) UPD: ('0', '1', ' ')
    char replace; // заменяет на реплейс (0,1) UPD: ('0', '1', ' ')
    char move; // передвигает сканер ('<', '>')
    int register; // потом переходит в регистр (1, 2, 3, .., n)

    public Register(char trigger, char replace, char move, int register) {
        this.trigger = trigger;
        this.replace = replace;
        this.move = move;
        this.register = register;
    }
}
