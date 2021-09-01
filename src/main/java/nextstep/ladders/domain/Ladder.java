package nextstep.ladders.domain;

import nextstep.ladders.domain.strategy.GeneratorSteategy;
import nextstep.ladders.domain.strategy.RandomGenerateStrategy;

import java.util.Arrays;
import java.util.Objects;

public class Ladder {

    private static final String REGEX_COMMA = ",";

    private final Lines lines;

    public Ladder(final Lines lines) {
        this.lines = lines;
    }

    public Ladder(final GeneratorSteategy generatorSteategy, final int height, final int numberOfPeople) {
        this(new Lines(generatorSteategy, height, numberOfPeople));
    }

    public Ladder(final RandomGenerateStrategy generator, final String maxLadderHeightText, final String participantsText) {
        this(generator, parseMaxLadderHeight(maxLadderHeightText), parseParticipantsCount(participantsText));
    }

    private static int parseParticipantsCount(final String participantsText) {
        return (int) (Arrays.stream(participantsText.split(REGEX_COMMA)).count());
    }

    private static int parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    public int start(final int index) {
        return lines.move(index);
    }

    public Lines getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
