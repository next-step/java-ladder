package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ladder {
    public boolean rungsCreated = false;
    private final List<Leg> legs;

    public Ladder(List<Leg> legs) {
        this.legs = legs;
        validate();
    }

    public int getHeight() {
        return legs.get(0).getHeight();
    }

    public List<Leg> getLegs() {
        return Collections.unmodifiableList(legs);
    }

    public void createRungs(RungStrategy rungStrategy) {
        if (!rungsCreated) {
            Rung.createRungs(this, rungStrategy);
            rungsCreated = true;
        }
    }

    private void validate() {
        validateLegs();
        validateLegsHeight();
        validateLegsNames();
    }

    private void validateLegs() {
        if (legs == null || legs.isEmpty()) {
            throw new IllegalArgumentException("사다리의 다리는 null이거나 비어있을 수 없습니다.");
        }
    }

    private void validateLegsHeight() {
        int height = getHeight();

        boolean isInvalidHeight = legs.stream()
            .anyMatch(leg -> leg.getHeight() != height);

        if (isInvalidHeight) {
            throw new IllegalArgumentException("사다리의 모든 다리는 같은 높이를 가져야 합니다.");
        }
    }

    private void validateLegsNames() {
        long distinctNameCount = legs.stream()
            .map(Leg::getName)
            .distinct()
            .count();

        if (distinctNameCount != legs.size()) {
            throw new IllegalArgumentException("사다리의 모든 다리는 이름이 달라야 합니다.");
        }
    }
}
