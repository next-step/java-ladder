package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Stairs {

    private static final int EXCEPT_FIRST_AND_LAST_PILLAR_COUNT = 2;
    static final int MIN_PILLAR_COUNT = 1;

    private final List<Stair> stairs;

    private Stairs(final List<Stair> stairs) {
        this.stairs = stairs;
    }

    public static Stairs of(final int pillarCount) {
        return new Stairs(createHorizontalStairs(pillarCount));
    }

    private static List<Stair> createHorizontalStairs(final int pillarCount) {
        validatePillarCount(pillarCount);

        List<Stair> stairs = new ArrayList<>();

        Stair currentStair = createFirst();
        stairs.add(currentStair);
        stairs.addAll(createMiddle(currentStair, pillarCount - EXCEPT_FIRST_AND_LAST_PILLAR_COUNT));
        stairs.add(createLast(currentStair));

        return stairs;
    }

    private static void validatePillarCount(final int pillarCount) {
        if (pillarCount < MIN_PILLAR_COUNT) {
            throw new IllegalArgumentException("기둥의 최소 1개 이상이어야 합니다.");
        }
    }

    private static Stair createFirst() {
        return Stair.createOfFirstPillar();
    }

    private static List<Stair> createMiddle(final Stair preStair, final int middlePillarCount) {
        List<Stair> middleStairs = new ArrayList<>();
        Stair stair = preStair;

        for (int i = 0; i < middlePillarCount; i++) {
            stair = stair.createOfMiddlePillar();
            middleStairs.add(stair);
        }

        return middleStairs;
    }

    private static Stair createLast(final Stair stair) {
        return stair.createOfLastPillar();
    }
}
