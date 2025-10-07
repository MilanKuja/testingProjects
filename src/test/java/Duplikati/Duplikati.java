package Duplikati;

import serialChecker.DeviceListReader;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplikati {
    public static void main(String[] args) {
        try {
            // Učitavanje fajlova
            List<String> lista1 = DeviceListReader.readDevices("gps (1).csv");
            List<String> lista2 = DeviceListReader.readDevices("gps (2).csv");

            // Sigurnosna provera
            if (lista1 == null) lista1 = new ArrayList<>();
            if (lista2 == null) lista2 = new ArrayList<>();

            // Set za brzu proveru elemenata iz lista2
            Set<String> set2 = new HashSet<>(lista2);

            // Pronađi razliku
            List<String> difference = new ArrayList<>();
            for (String item : lista1){
                if (!set2.contains(item)) {
                    difference.add(item);
                }
            }

            System.out.println("Razlika: " + difference);

            try (FileWriter writer = new FileWriter("difference_list.txt")) {
                for (String item : difference) {
                    writer.write(item + System.lineSeparator());
                }
            }

            System.out.println("Razlika je eksportovana u difference_list.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}