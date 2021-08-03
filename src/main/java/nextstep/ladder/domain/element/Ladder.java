package nextstep.ladder.domain.element;

import nextstep.ladder.domain.dto.LadderFigure;
import nextstep.ladder.domain.info.LadderInfo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Plane> planes;

    private Ladder(LadderInfo ladderInfo) {
        validate(ladderInfo);
        planes = createPlanes(ladderInfo);
    }

    private void validate(LadderInfo ladderInfo) {
        if (Objects.isNull(ladderInfo)) {
            throw new IllegalArgumentException("LadderInfo는 null이면 안됩니다");
        }
    }

    public static Ladder create(LadderInfo ladderInfo) {
        return new Ladder(ladderInfo);
    }

    public List<LadderFigure> getFigures() {
        return planes.stream()
                .map(Plane::getLines)
                .map(LadderFigure::of)
                .collect(Collectors.toList());
    }

    private List<Plane> createPlanes(LadderInfo ladderInfo) {
        return Stream.generate(() -> Plane.create(ladderInfo))
                .limit(ladderInfo.getLadderHeight())
                .collect(Collectors.toList());
    }

}
