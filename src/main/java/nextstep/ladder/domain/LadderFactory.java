package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderFactory {
    public static Ladder createLadder(List<String> names, int height) {
        List<Leg> legs = createLegs(names, height);
        Rung.createRungs(legs, height);
        return new Ladder(legs);
    }

    private static List<Leg> createLegs(List<String> names, int height) {
        return names.stream()
            .map(name -> new Leg(name, height))
            .collect(Collectors.toList());
    }
}
