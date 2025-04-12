package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Leg> legs;
    private final JunctionMover mover = new JunctionMover();

    public Ladder(List<Leg> legs) {
        validate(legs);
        this.legs = legs;
    }

    public int getHeight() {
        return legs.get(0).getHeight();
    }

    public List<Leg> getLegs() {
        return Collections.unmodifiableList(legs);
    }

    public void applyRungs(RungStrategy rungStrategy) {
        for (int level = 0; level < getHeight(); level++) {
            Row row = getRow(level);
            row.applyRungs(rungStrategy);
        }
    }

    private Row getRow(int level) {
        List<Junction> junctions = getLegs().stream()
            .map(leg -> leg.getJunction(level))
            .collect(Collectors.toList());
        return new Row(junctions);
    }

    public LadderResults run() {
        Map<ParticipantName, String> results = new LinkedHashMap<>();

        for (Leg leg : legs) {
            ParticipantName name = leg.getName();
            Junction start = leg.getStart();
            Junction result = mover.moveToEnd(start, name);

            results.put(name, result.getResult());
        }

        return new LadderResults(results);
    }

    private static void validate(List<Leg> legs) {
        validateLegs(legs);
        validateLegsHeight(legs);
        validateLegsNames(legs);
    }

    private static void validateLegs(List<Leg> legs) {
        if (legs == null || legs.isEmpty()) {
            throw new IllegalArgumentException("사다리의 다리는 null이거나 비어있을 수 없습니다.");
        }
    }

    private static void validateLegsHeight(List<Leg> legs) {
        int height = legs.get(0).getHeight();

        boolean isInvalidHeight = legs.stream()
            .anyMatch(leg -> leg.getHeight() != height);

        if (isInvalidHeight) {
            throw new IllegalArgumentException("사다리의 모든 다리는 같은 높이를 가져야 합니다.");
        }
    }

    private static void validateLegsNames(List<Leg> legs) {
        long distinctNameCount = legs.stream()
            .map(Leg::getName)
            .distinct()
            .count();

        if (distinctNameCount != legs.size()) {
            throw new IllegalArgumentException("사다리의 모든 다리는 이름이 달라야 합니다.");
        }
    }


}
