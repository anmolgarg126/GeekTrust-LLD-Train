package org.lld.problems.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Route {
    private List<Stop> stops;
    private RouteName routeName;
}
