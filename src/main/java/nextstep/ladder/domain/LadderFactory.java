package nextstep.ladder.domain;

import java.util.List;

public class LadderFactory {
    public static Ladder createLadder(List<String> names, int height) {
        List<Leg> legs = Leg.createLegs(names, height);
        Ladder ladder = new Ladder(legs);
        ladder.createRungs(new RandomCreateRungStrategy());
        return ladder;
    }
}
