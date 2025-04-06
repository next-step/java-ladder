package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Leg> legs;
    private boolean applyRungsCalled = false;

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

    public synchronized void applyRungs(RungStrategy rungStrategy) {
        if (applyRungsCalled) {
            return;
        }

        for (int level = 0; level < getHeight(); level++) {
            Row row = getRow(level);
            row.applyRungs(rungStrategy);
        }

        applyRungsCalled = true;
    }

    private Row getRow(int level) {
        List<Junction> junctions = getLegs().stream()
            .map(leg -> leg.getJunction(level))
            .collect(Collectors.toList());
        return new Row(junctions);
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
