package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Stairs {

    private static final int FIRST_AND_LAST_PILLAR_COUNT = 2;

    private final List<Stair> stairs;

    private Stairs(final List<Stair> stairs) {
        this.stairs = stairs;
    }

    public static Stairs of(final PillarCount pillarCount) {
        return new Stairs(createHorizontalStairs(pillarCount));
    }

    private static List<Stair> createHorizontalStairs(final PillarCount pillarCount) {
        List<Stair> stairs = new ArrayList<>();
        int middlePillarCount = pillarCount.getValue() - FIRST_AND_LAST_PILLAR_COUNT;

        Stair currentStair = Stair.createOfFirstPillar();
        stairs.add(currentStair);
        for (int i = 0; i < middlePillarCount; i++) {
            currentStair = currentStair.createOfMiddlePillar();
            stairs.add(currentStair);
        }
        stairs.add(currentStair.createOfLastPillar());

        return stairs;
    }

    public List<Stair> getStairs() {
        return stairs;
    }
}
