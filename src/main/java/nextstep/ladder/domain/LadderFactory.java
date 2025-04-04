package nextstep.ladder.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LadderFactory {
    public static Ladder createLadder(List<String> names, int height) {
        List<Leg> legs = Leg.createLegs(names, height);
        Ladder ladder = new Ladder(legs);
        ladder.applyRungs(new RandomRungStrategy(ThreadLocalRandom.current()));
        return ladder;
    }
}
