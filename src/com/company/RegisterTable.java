package com.company;

import java.util.ArrayList;

public class RegisterTable {
    private static ArrayList<Register> list = new ArrayList<>();

    public static void add(int trigger, int replace, char move, int register) {
        list.add(new Register(trigger, replace, move, register));
    }
    public static void set(int id, int trigger, int replace, char move, int register) {
        list.set(id, new Register(trigger, replace, move, register));
    }
    public static Register get(int id) {
        return list.get(id);
    }
    public static void remove(int id) {
        list.remove(id);
    }

    public static int size() {
        return list.size();
    }




}
