package ladder.domain.ladder;

import ladder.domain.ladder.shape.PillarCount;
import ladder.exception.ErrorMessage;

import java.util.*;

public class Stairs {

    private static final int FIRST_AND_LAST_PILLAR_COUNT = 2;

    private final List<Stair> stairs;

    private Stairs(final List<Stair> stairs) {
        this.stairs = stairs;
    }

    public static Stairs of(final PillarCount pillarCount) {
        validatePillarCount(pillarCount);
        return new Stairs(createHorizontalStairs(pillarCount));
    }

    private static void validatePillarCount(final PillarCount pillarCount) {
        if (Objects.isNull(pillarCount)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    private static List<Stair> createHorizontalStairs(final PillarCount pillarCount) {
        if (pillarCount.isMinCount()) {
            return Collections.singletonList(Stair.of(StairState.EMPTY));
        }

        List<Stair> stairs = new ArrayList<>();
        int middlePillarCount = pillarCount.getValue() - FIRST_AND_LAST_PILLAR_COUNT;

        Stair currentStair = Stair.createOfFirstPillar();
        stairs.add(currentStair);
        for (int i = 0; i < middlePillarCount; i++) {
            currentStair = currentStair.createOfNextPillar();
            stairs.add(currentStair);
        }
        stairs.add(currentStair.createOfLastPillar());

        return stairs;
    }

    public List<Stair> getStairs() {
        return stairs;
    }

    public int getWidth() {
        return stairs.size();
    }

    public int move(final int position) {
        return indexOf(position).move(position);
    }

    private Stair indexOf(final int index) {
        return stairs.get(index);
    }
}
