package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rung {

    public static void createRungs(List<Leg> legs, int height) {
        createRungs(legs, height, new RandomRungStrategy());
    }

    public static void createRungs(List<Leg> legs, int height, RungStrategy rungStrategy) {
        for (int i = 0; i < height; i++) {
            final int level = i;

            List<Junction> junctions = legs.stream()
                .map(leg -> leg.getJunction(level))
                .collect(Collectors.toList());

            createRungs(junctions, rungStrategy);
        }
    }

    private static void createRungs(List<Junction> junctions, RungStrategy rungStrategy) {
        for (int i = 0; i < junctions.size() - 1; i++) {
            Junction junction = junctions.get(i);
            Junction rightJunction = junctions.get(i + 1);
            rungStrategy.connect(junction, rightJunction);
        }
    }

}
