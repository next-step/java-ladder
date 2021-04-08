package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private static final LineGenerator LINE_GENERATOR = LineGenerator.getInstance();
    private final Participants participants;
    private final Lines lines;

    private LadderGame(final List<String> userName, final List<Line> lines) {
        this.participants = Participants.of(userName);
        this.lines = Lines.of(lines);
    }

    public static LadderGame of(final LadderHeight ladderHeight, final List<String> userName) {
        int width = userName.size() - 1;
        int height = ladderHeight.getLadderHeight();
        List<Line> lines = LINE_GENERATOR.generateLines(height, width);

        return new LadderGame(userName, lines);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Lines getLines() {
        return lines;
    }
}
