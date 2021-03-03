package com.company;

public class Register {
    int trigger; // если находит то (0,1)
    int replace; // заменяет на реплейс (0,1)
    char move; // передвигает сканер ('<', '>')
    int register; // потом переходит в регистр (1, 2, 3, .., n)

    public Register(int trigger, int replace, char move, int register) {
        this.trigger = trigger;
        this.replace = replace;
        this.move = move;
        this.register = register;
    }
}
