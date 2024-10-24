package org.lld.problems.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stop {
    private int distance;
    private String name;
}
