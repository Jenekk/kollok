package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        shoesList shoStore = new shoesList("input.txt");

       shoStore.groupByDate();

        System.out.println("Введите имя лекарства для поиска: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader sysIn = new BufferedReader(isr);

        String name = sysIn.readLine();
        shoStore.binarySearch(name);
        shoStore.sortByPrice();
    }
}