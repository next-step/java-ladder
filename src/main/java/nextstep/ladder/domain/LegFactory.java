package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LegFactory {

    public static List<Leg> createLegs(List<String> names, int height) {
        return names.stream()
            .map(name -> new Leg(name, height))
            .collect(Collectors.toList());
    }

}
