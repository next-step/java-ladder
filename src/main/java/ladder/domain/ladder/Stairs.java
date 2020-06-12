package ladder.domain.ladder;

import ladder.domain.ladder.shape.PillarCount;
import ladder.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        int middlePillarCount = getMiddlePillarCount(pillarCount.getValue());

        Stair currentStair = Stair.createOfFirstPillar();
        stairs.add(currentStair);
        for (int i = 0; i < middlePillarCount; i++) {
            currentStair = currentStair.createOfNextPillar();
            stairs.add(currentStair);
        }
        stairs.add(currentStair.createOfLastPillar());

        return stairs;
    }

    private static int getMiddlePillarCount(final int pillarCount) {
        return pillarCount - FIRST_AND_LAST_PILLAR_COUNT;
    }

    public List<Stair> getStairs() {
        return stairs;
    }

    public int getWidth() {
        return stairs.size();
    }

    public Position move(final Position position) {
        return indexOf(position).move(position);
    }

    private Stair indexOf(final Position position) {
        return stairs.get(position.getPosition());
    }
}
