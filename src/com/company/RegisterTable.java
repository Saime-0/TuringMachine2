package com.company;

import java.util.ArrayList;

public class RegisterTable {
    private static ArrayList<Register> list = new ArrayList<>();

    public static void add(String[] param) {
        list.add(new Register(param));
    }

    public static void set(int id, String[] param) {
        list.set(id, new Register(param));
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
