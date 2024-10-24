package org.lld.problems.service;

import org.lld.problems.repo.RouteRepo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TrainService {

    public static String getArrivalOrder(List<String> stops) {
        Set<String> stopsBeforeHyd = RouteRepo.getStopsBeforeHyd();
        List<String> res = new LinkedList<>();
        res.add("ARRIVAL");

        for (String stop : stops) {
            if (!stopsBeforeHyd.contains(stop)) {
                res.add(stop);
            }
        }
        return String.join(" ", res);
    }


    public static String getDepartureOrder(List<String> trainA, List<String> trainB) {
        List<String> departureOrder = new LinkedList<>();
        departureOrder.addAll(trainA.subList(2, trainA.size()));
        departureOrder.addAll(trainB.subList(2, trainB.size()));

        List<String> result = new ArrayList<>();
        List<String> orderedStopsByDistanceAfterHyb = RouteRepo.getDescendingOrderedStopsByDistanceAfterHyb();

        result.add("DEPARTURE");
        result.add("TRAIN_AB");
        result.add("ENGINE");
        result.add("ENGINE");

        for (String s : orderedStopsByDistanceAfterHyb) {
            while (departureOrder.contains(s)) {
                result.add(s);
                departureOrder.remove(s);
            }
        }

        return String.join(" ", result);
    }
}
