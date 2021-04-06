package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.strategy.LineConnectionRandomStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private static final int LADDER_HEIGHT_MIN = 1;
    public static final String LADDER_HEIGHT_MIN_MESSAGE = "사다리의 최소 높이는 1입니다.";
    private final Participants participants;
    private final Lines lines;

    private LadderGame(final int ladderHeight, final String[] userName, final List<Line> lines) {
        validation(ladderHeight);
        this.participants = Participants.of(userName);
        this.lines = Lines.of(lines);
    }

    public static LadderGame of(final int ladderHeight, final String[] userName) {
        int width = userName.length - 1;
        List<Line> lines = IntStream.range(0, ladderHeight)
                .mapToObj(h -> Line.of(width, new LineConnectionRandomStrategy()))
                .collect(Collectors.toList());

        return new LadderGame(ladderHeight, userName, lines);
    }

    private void validation(final int ladderHeight) {
        if (ladderHeight < LADDER_HEIGHT_MIN) {
            throw new LadderException(LADDER_HEIGHT_MIN_MESSAGE);
        }
    }
}
