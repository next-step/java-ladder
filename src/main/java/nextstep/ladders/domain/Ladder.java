package nextstep.ladders.domain;

import nextstep.ladders.domain.strategy.DirectionGenerator;
import nextstep.ladders.domain.strategy.DirectionRandomGenerate;

import java.util.Arrays;
import java.util.Objects;

public class Ladder {

    private static final String REGEX_COMMA = ",";

    private final LadderLines ladderLines;

    public Ladder(final LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public Ladder(final DirectionGenerator directionGenerator, final int height, final int numberOfPeople) {
        this(new LadderLines(directionGenerator, height, numberOfPeople));
    }

    public Ladder(final DirectionRandomGenerate generator, final String maxLadderHeightText, final String participantsText) {
        this(generator, parseMaxLadderHeight(maxLadderHeightText), parseParticipantsCount(participantsText));
    }

    private static int parseParticipantsCount(final String participantsText) {
        return (int) (Arrays.stream(participantsText.split(REGEX_COMMA)).count());
    }

    private static int parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    public int start(final int index) {
        return ladderLines.move(index);
    }

    public LadderLines getLines() {
        return ladderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
