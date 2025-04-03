package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderFactory {
    public static Ladder createLadder(List<String> names, int height) {
        List<Leg> legs = LegFactory.createLegs(names, height);
        Ladder ladder = new Ladder(legs);
        ladder.createRungs(new RandomRungStrategy());
        return ladder;
    }
}
