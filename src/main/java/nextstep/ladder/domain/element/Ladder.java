package nextstep.ladder.domain.element;

import nextstep.ladder.domain.dto.LadderFigure;
import nextstep.ladder.domain.info.LadderInfo;
import nextstep.ladder.domain.play.PlayResult;
import nextstep.ladder.domain.play.PlayerPosition;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public PlayResult move() {
        return IntStream.range(0, getLadderWidth())
                .mapToObj(PlayerPosition::of)
                .map(this::move)
                .collect(Collectors.collectingAndThen(Collectors.toList(), PlayResult::of));
    }

    private PlayerPosition move(PlayerPosition position) {
        return planes.stream()
                .reduce(position,
                        (movingPosition, plane) -> plane.move(movingPosition),
                        (prePosition, curPosition) -> {
                            throw new IllegalStateException("병렬 스트림이 아니므로 호출되면 안됩니다.");
                        });
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

    private int getLadderWidth() {
        return planes.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("사다리가 존재하지 않습니다."))
                .width();
    }

}
