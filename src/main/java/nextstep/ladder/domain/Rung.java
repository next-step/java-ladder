package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rung {

    public static void createRungs(Ladder ladder, CreateRungStrategy createRungStrategy) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            final int level = i;

            List<Junction> junctions = ladder.getLegs().stream()
                .map(leg -> leg.getJunction(level))
                .collect(Collectors.toList());

            createRungs(junctions, createRungStrategy);
        }
    }

    private static void createRungs(List<Junction> junctions, CreateRungStrategy createRungStrategy) {
        for (int i = 0; i < junctions.size() - 1; i++) {
            Junction junction = junctions.get(i);
            Junction rightJunction = junctions.get(i + 1);
            createRungStrategy.create(junction, rightJunction);
        }
    }

}
