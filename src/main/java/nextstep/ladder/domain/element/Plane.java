package nextstep.ladder.domain.element;

import nextstep.ladder.domain.info.LadderInfo;
import nextstep.ladder.domain.play.PlayerPosition;
import nextstep.ladder.domain.strategy.LineCreateStrategyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Plane {
    private static final int START_INDEX = 0;
    private static final int COUNT_OF_START_PILLAR = 1;
    private static final int ONE = 1;

    private final List<Pillar> pillars;

    private Plane(LadderInfo ladderInfo) {
        validate(ladderInfo);

        pillars = new ArrayList<>(ladderInfo.getLadderWidth());
        createPillars(ladderInfo);
    }

    private void validate(LadderInfo ladderInfo) {
        if (Objects.isNull(ladderInfo)) {
            throw new IllegalArgumentException("LadderInitInfo는 null이면 안된다");
        }
    }

    public static Plane create(LadderInfo ladderInfo) {
        return new Plane(ladderInfo);
    }

    public List<Boolean> getLines() {
        return pillars.stream()
                .map(Pillar::hasRightLine)
                .collect(Collectors.toList());
    }

    public int width() {
        return pillars.size();
    }

    public PlayerPosition move(PlayerPosition position) {
        return pillars.get(position.getValue()).move(position);
    }

    private void createPillars(LadderInfo ladderInfo) {
        IntStream.range(0, ladderInfo.getLadderWidth())
                .forEach(idx -> pillars.add(createPillar(ladderInfo, idx)));
    }

    private Pillar createPillar(LadderInfo ladderInfo, int idx) {
        if (isLadderStart(idx)) {
            return Pillar.makeStart(LineCreateStrategyFactory.getStrategy(ladderInfo));
        }

        if (isLadderEnd(ladderInfo, idx)) {
            return getPrevPillars(idx).makeEnd();
        }

        return getPrevPillars(idx).makeMiddle(ladderInfo.getLineCreateStrategy());
    }

    private boolean isLadderStart(int idx) {
        return idx == START_INDEX;
    }

    private boolean isLadderEnd(LadderInfo ladderInfo, int idx) {
        return idx == getLadderWidthLastIndex(ladderInfo);
    }

    private int getLadderWidthLastIndex(LadderInfo ladderInfo) {
        return ladderInfo.getLadderWidth() - COUNT_OF_START_PILLAR;
    }

    private Pillar getPrevPillars(int idx) {
        return pillars.get(idx - ONE);
    }

}
