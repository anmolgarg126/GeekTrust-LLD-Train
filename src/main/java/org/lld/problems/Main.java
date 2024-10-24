package org.lld.problems;

import org.lld.problems.service.TrainService;
import org.lld.problems.utils.Utility;

import java.util.List;

/*
Question: https://www.geektrust.com/coding/detailed/train
 */
public class Main {
    public static void main(String[] args) {

        List<List<String>> trainSchedule = Utility.getTrainSchedule(args[0]);
        List<String> trainA = trainSchedule.get(0);
        List<String> trainB = trainSchedule.get(1);


        System.out.println(TrainService.getArrivalOrder(trainA));
        System.out.println(TrainService.getArrivalOrder(trainB));

        System.out.println(TrainService.getDepartureOrder(trainA, trainB));
    }
}