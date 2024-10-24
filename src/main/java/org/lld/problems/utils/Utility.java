package org.lld.problems.utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utility {

    @SneakyThrows
    public static List<List<String>> getTrainSchedule(String filePath) {
        // the file to be opened for reading
        FileInputStream fis = new FileInputStream(filePath);
        Scanner sc = new Scanner(fis); // file to be scanned
        // returns true if there is another line to read
        List<List<String>> schedule = new ArrayList<>();
        while (sc.hasNextLine()) {
            //Add your code here to process input commands
            String[] input = sc.nextLine().split("\\s+");
            List<String> routes = new ArrayList<>(input.length);
            routes.addAll(Arrays.asList(input));

            schedule.add(routes);
        }
        sc.close(); // closes the scanner

        return schedule;
    }


}
