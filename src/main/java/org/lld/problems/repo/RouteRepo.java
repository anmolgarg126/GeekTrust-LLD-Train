package org.lld.problems.repo;

import org.lld.problems.models.Route;
import org.lld.problems.models.RouteName;
import org.lld.problems.models.Stop;

import java.util.*;

public class RouteRepo {

    private static final Route A_C;
    private static final Route B_C;
    private static final Route C_D;
    private static final Route C_E;

    static {
        A_C = getACRoute();
        B_C = getBCRoute();
        C_D = getCDRoute();
        C_E = getCERoute();
    }

    // C- HYB
    private static Route getBCRoute() {
        //B-C
        List<Stop> b_c_stops = new LinkedList<>();
        b_c_stops.add(new Stop(0, "TVC"));
        b_c_stops.add(new Stop(300, "SRR"));
        b_c_stops.add(new Stop(600, "MAQ"));
        b_c_stops.add(new Stop(1000, "MAO"));
        b_c_stops.add(new Stop(1400, "PNE"));
        b_c_stops.add(new Stop(2000, "HYB"));

        return new Route(b_c_stops, RouteName.B_C);
    }

    private static Route getCDRoute() {
        //C-D
        List<Stop> c_d_stops = new LinkedList<>();
        c_d_stops.add(new Stop(0, "HYB"));
        c_d_stops.add(new Stop(400, "NGP"));
        c_d_stops.add(new Stop(700, "ITJ"));
        c_d_stops.add(new Stop(800, "BPL"));
        c_d_stops.add(new Stop(1300, "AGA"));
        c_d_stops.add(new Stop(1500, "NDL"));

        return new Route(c_d_stops, RouteName.C_D);
    }

    private static Route getCERoute() {
        //C-E
        List<Stop> c_e_stops = new LinkedList<>();
        c_e_stops.add(new Stop(0, "HYB"));
        c_e_stops.add(new Stop(400, "NGP"));
        c_e_stops.add(new Stop(700, "ITJ"));
        c_e_stops.add(new Stop(800, "BPL"));
        c_e_stops.add(new Stop(1800, "PTA"));
        c_e_stops.add(new Stop(2200, "NJP"));
        c_e_stops.add(new Stop(2700, "GHY"));

        return new Route(c_e_stops, RouteName.C_E);
    }

    private static Route getACRoute() {
        //A-C
        List<Stop> a_c_stops = new LinkedList<>();
        a_c_stops.add(new Stop(0, "CHN"));
        a_c_stops.add(new Stop(350, "SLM"));
        a_c_stops.add(new Stop(550, "BLR"));
        a_c_stops.add(new Stop(900, "KRN"));
        a_c_stops.add(new Stop(1200, "HYB"));

        return new Route(a_c_stops, RouteName.A_C);
    }

    public static Set<String> getStopsBeforeHyd() {
        Set<String> stopsBeforeHyd = new HashSet<>();

        for (int i = 0; i < A_C.getStops().size() - 1; i++) {
            stopsBeforeHyd.add(A_C.getStops().get(i).getName());
        }
        for (int i = 0; i < B_C.getStops().size() - 1; i++) {
            stopsBeforeHyd.add(B_C.getStops().get(i).getName());
        }

        return stopsBeforeHyd;
    }

    public static List<String> getDescendingOrderedStopsByDistanceAfterHyb() {
        List<Stop> cdRoute = C_D.getStops();
        List<Stop> ceRoute = C_E.getStops();
        int i = cdRoute.size() - 1, j = ceRoute.size() - 1;

        List<String> result = new ArrayList<>();
        while (i > 0 || j > 0) {
            if (i <= 0) {
                result.add(ceRoute.get(j).getName());
                j--;
            } else if (j <= 0) {
                result.add(cdRoute.get(i).getName());
                i--;
            } else if (cdRoute.get(i).getDistance() > ceRoute.get(j).getDistance()) {
                result.add(cdRoute.get(i).getName());
                i--;
            } else {
                result.add(ceRoute.get(j).getName());
                j--;
            }
        }

        return result;
    }
}
