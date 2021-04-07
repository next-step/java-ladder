package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import java.util.List;

public class LadderGame {

    private static final int LADDER_HEIGHT_MIN = 1;
    private static final String LADDER_HEIGHT_MIN_MESSAGE = "사다리의 최소 높이는 1입니다.";
    private static final LineGenerator lineGenerator = LineGenerator.getInstance();
    private final Participants participants;
    private final Lines lines;

    private LadderGame(final int ladderHeight, final String[] userName, final List<Line> lines) {
        validation(ladderHeight);
        this.participants = Participants.of(userName);
        this.lines = Lines.of(lines);
    }

    public static LadderGame of(final int ladderHeight, final String[] userName) {
        int width = userName.length - 1;
        List<Line> lines = lineGenerator.generateLines(ladderHeight, width);

        return new LadderGame(ladderHeight, userName, lines);
    }

    private void validation(final int ladderHeight) {
        if (ladderHeight < LADDER_HEIGHT_MIN) {
            throw new LadderException(LADDER_HEIGHT_MIN_MESSAGE);
        }
    }
}
